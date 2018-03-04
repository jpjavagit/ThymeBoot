package com.thyme.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thyme.boot.entities.Customer;
import com.thyme.boot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	/**
	 * Get all objects of type Customers
	 * @author joao.sanches
	 * @return List<Customer>
	 */
	public List<Customer> listCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		repository.findAll().forEach(customers::add);
		return customers;
	}
	
	/**
	 * Save the Object 
	 * @param customer : Customer
	 */
	public void save(Customer customer){
		repository.save(customer);
	}
}
