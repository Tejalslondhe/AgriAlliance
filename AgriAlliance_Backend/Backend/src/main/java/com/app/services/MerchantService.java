package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.MerchantDto;
import com.app.dto.MerchantSignup;

@Service
public interface MerchantService {

<<<<<<< HEAD
	MerchantSignup merchantRegistration(MerchantSignup reqDTO);
=======
	//MerchantSignup merchantRegistration(MerchantSignup reqDTO);

	MerchantDto addNewMerchant(MerchantDto newMerchant) throws InvalidCredentialsException;

	List<MerchantDto> displayAllMerchant();

	void deleteMerchant(Long id);

	MerchantDto updateMerchant(Long id, MerchantDto updateMerchant);
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503

	MerchantDto addNewMerchant(MerchantDto newMerchant) throws InvalidCredentialsException;

	List<MerchantDto> displayAllMerchant();

	void deleteMerchant(Long id);

	MerchantDto updateMerchant(Long id, MerchantDto updateMerchant);

}
