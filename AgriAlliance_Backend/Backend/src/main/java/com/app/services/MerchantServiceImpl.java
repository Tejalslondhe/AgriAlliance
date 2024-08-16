package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.FarmerSignup;
import com.app.dto.MerchantDto;
import com.app.dto.MerchantSignup;
import com.app.entities.Farmer;
import com.app.entities.Merchant;
import com.app.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	/*@Override
	public MerchantDto addNewMerchant(MerchantDto newMerchant) throws InvalidCredentialsException {

		Merchant merchant = mapper.map(newMerchant, Merchant.class);
		if (merchant.getAddress() != null) {
			merchant.getAddress().setId(null); // Ensures a new Address is created
		}
		Merchant savedMerchant = merchantDao.save(merchant);
		return mapper.map(savedMerchant, MerchantDto.class);
	}*/

	@Override
	public List<MerchantDto> displayAllMerchant() {
		List<Merchant> merchants = merchantRepository.findAll();
		return merchants.stream().map(merchant -> mapper.map(merchant, MerchantDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteMerchant(Long id) {

		Merchant merchant = merchantRepository.findById(id).orElseThrow(() -> new RuntimeException("Merchant not found"));
		merchantRepository.delete(merchant);
	}

	@Override
	public MerchantDto updateMerchant(Long id, MerchantDto updatetMerchant) {
		Merchant merchant = merchantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Merchant not found with ID: " + id));

		mapper.map(updatetMerchant, merchant);

		merchant = merchantRepository.save(merchant);

		return mapper.map(merchant, MerchantDto.class);
	}

	@Override
	public MerchantSignup merchantRegistration(MerchantSignup reqDTO) {
		Merchant merchant = mapper.map(reqDTO, Merchant.class);

		if (merchantRepository.existsByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist !");

		merchant.setPassword(encoder.encode(merchant.getPassword()));
		return mapper.map(merchantRepository.save(merchant), MerchantSignup.class);
	}

	@Override
    public void deleteMerchantByEmail(String email) {
        Merchant merchant = merchantRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Merchant not found with email: " + email));
        merchantRepository.delete(merchant);
    }

    @Override
    public MerchantDto updateMerchantByEmail(String email, MerchantDto updateMerchant) {
        Merchant merchant = merchantRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Merchant not found with email: " + email));

        mapper.map(updateMerchant, merchant);
        merchant = merchantRepository.save(merchant);
        
        return mapper.map(merchant, MerchantDto.class);
    }
}
