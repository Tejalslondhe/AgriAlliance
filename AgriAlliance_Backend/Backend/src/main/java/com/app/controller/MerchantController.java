package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MerchantDto;
import com.app.entities.Merchant;
import com.app.services.MerchantService;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	@PostMapping
	public MerchantDto add(@RequestBody MerchantDto newMerchant)
	{
		return merchantService.addNewMerchant(newMerchant);
	}
	
	@GetMapping
	public List<MerchantDto> display()
	{
		return merchantService.displayAllMerchant();
	}
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id)
	{
		merchantService.deleteMerchant(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/{id}")
	public MerchantDto update(@PathVariable Long id ,@RequestBody MerchantDto merchant)
	{
		return merchantService.updateMerchant(id,merchant);
	}
}
