package com.app.services;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.entities.Doctor;
import com.app.entities.Farmer;
import com.app.entities.Merchant;
import com.app.entities.User;
import com.app.entities.Worker;
import com.app.enums.Role;
import com.app.repository.DoctorRepository;
import com.app.repository.FarmerRepository;
import com.app.repository.MerchantRepository;
import com.app.repository.WorkerRepository;

@Service
public class UserService {

    private final FarmerRepository farmerRepository;
    private final WorkerRepository workerRepository;
    private final MerchantRepository merchantRepository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(FarmerRepository farmerRepository, WorkerRepository workerRepository,
                       MerchantRepository merchantRepository, DoctorRepository doctorRepository,
                       PasswordEncoder passwordEncoder) {
        this.farmerRepository = farmerRepository;
        this.workerRepository = workerRepository;
        this.merchantRepository = merchantRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Farmer registerFarmer(Farmer farmer) {
        farmer.setPassword(passwordEncoder.encode(farmer.getPassword()));
        farmer.setRole(Role.FARMER);
        return farmerRepository.save(farmer);
    }

    public Worker registerWorker(Worker worker) {
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        worker.setRole(Role.WORKER);
        return workerRepository.save(worker);
    }

    public Merchant registerMerchant(Merchant merchant) {
        merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
        merchant.setRole(Role.MERCHANT);
        return merchantRepository.save(merchant);
    }

    public Doctor registerDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctor.setRole(Role.DOCTOR);
        return doctorRepository.save(doctor);
    }

    public Optional<? extends User> findByEmail(String email) {
        Optional<Farmer> farmer = farmerRepository.findByEmail(email);
        if (farmer.isPresent()) return farmer;

        Optional<Worker> worker = workerRepository.findByEmail(email);
        if (worker.isPresent()) return worker;

        Optional<Merchant> merchant = merchantRepository.findByEmail(email);
        if (merchant.isPresent()) return merchant;

        return doctorRepository.findByEmail(email);
    }
}
