package com.app.services;

import com.app.dto.MerchantSignup;
import com.app.dto.UserSignup;

public interface MerchantService {
	
	MerchantSignup merchantRegistration(MerchantSignup reqDTO);

}
