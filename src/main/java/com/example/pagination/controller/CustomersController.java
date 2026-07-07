package com.example.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.entity.Customers;
import com.example.pagination.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomersController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public Page<Customers> findPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return service.getAll(page, size);
	}

	@GetMapping("/{id}")
	public Customers getOne(@PathVariable Long id) {
		return service.getOneCustomer(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers cus) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(id, cus));
	}

}
