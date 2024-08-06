package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
