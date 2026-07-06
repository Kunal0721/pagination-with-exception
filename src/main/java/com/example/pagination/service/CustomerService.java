package com.example.pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.pagination.entity.Customers;
import com.example.pagination.errors.CustomerNotFound;
import com.example.pagination.repository.CustomersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	@Autowired
	private CustomersRepository repo;

	public Page<Customers> getAll(int page, int size) {
		Pageable pagable = PageRequest.of(page, size);
		return repo.findAll(pagable);
	}
	
	public Customers getOneCustomer(Long id) {
		return repo.findById(id).orElseThrow(() -> new CustomerNotFound("Customer not found : "  + id));
	}
}

// 100 -> page = 0, size = 10 
// page = 1, size = 10 => 11 to 20
