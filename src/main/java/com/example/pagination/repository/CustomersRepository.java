package com.example.pagination.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pagination.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

	Page<Customers> findAll(Pageable pageable);
}
