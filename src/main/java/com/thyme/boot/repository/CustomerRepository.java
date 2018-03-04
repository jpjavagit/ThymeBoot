package com.thyme.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thyme.boot.entities.Customer;

/**
 * Spring-Data support 
 * @author joao.sanches
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
