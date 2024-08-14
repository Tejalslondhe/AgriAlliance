package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.repository.DoctorRepository;
import com.app.repository.FarmerRepository;
import com.app.repository.MerchantRepository;
import com.app.repository.WorkerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails user = farmerRepository.findByEmail(email).map(farmer -> new CustomUserDetails(farmer))
				.orElseGet(() -> workerRepository.findByEmail(email).map(worker -> new CustomUserDetails(worker))
						.orElseGet(() -> merchantRepository.findByEmail(email)
								.map(merchant -> new CustomUserDetails(merchant))
								.orElseGet(() -> doctorRepository.findByEmail(email)
										.map(doctor -> new CustomUserDetails(doctor))
										.orElseThrow(() -> new UsernameNotFoundException("User not found")))));

		return user;
	}
}
