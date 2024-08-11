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

/*
 * @Service public class CustomUserDetailsService implements UserDetailsService
 * {
 * 
 * private final UserService userService;
 * 
 * public CustomUserDetailsService(UserService userService) { this.userService =
 * userService; }
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { // Retrieve user by email User user =
 * userService.findByEmail(email) .orElseThrow(() -> new
 * UsernameNotFoundException("User not found with email: " + email));
 * 
 * // Return UserDetails with the retrieved user return new
 * CustomUserDetails(user); } }
 * 
 * 
 */

/*
 * package com.app.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.app.entities.User; // Common interface or base class for Farmer,
 * Merchant, etc. import com.app.repository.FarmerRepository; import
 * com.app.repository.MerchantRepository; import
 * com.app.repository.WorkerRepository; import
 * com.app.repository.DoctorRepository;
 * 
 * import java.util.Optional;
 * 
 * @Service
 * 
 * @Transactional public class CustomUserDetailsService implements
 * UserDetailsService {
 * 
 * @Autowired private FarmerRepository farmerRepo;
 * 
 * @Autowired private MerchantRepository merchantRepo;
 * 
 * @Autowired private WorkerRepository workerRepo;
 * 
 * @Autowired private DoctorRepository doctorRepo;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { Optional<User> userOpt =
 * farmerRepo.findByEmail(email) .map(user -> (User) user) .or(() ->
 * merchantRepo.findByEmail(email).map(user -> (User) user)) .or(() ->
 * workerRepo.findByEmail(email).map(user -> (User) user)) .or(() ->
 * doctorRepo.findByEmail(email).map(user -> (User) user));
 * 
 * User user = userOpt.orElseThrow(() -> new
 * UsernameNotFoundException("User not found"));
 * 
 * return new CustomUserDetails(user); }
 * 
 * 
 * }
 */