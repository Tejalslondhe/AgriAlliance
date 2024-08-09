package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.MerchantDto;
import com.app.dto.MerchantSignup;

@Service
public interface MerchantService {

	//MerchantSignup merchantRegistration(MerchantSignup reqDTO);

	MerchantDto addNewMerchant(MerchantDto newMerchant) throws InvalidCredentialsException;

	List<MerchantDto> displayAllMerchant();

	void deleteMerchant(Long id);

	MerchantDto updateMerchant(Long id, MerchantDto updateMerchant);

}
