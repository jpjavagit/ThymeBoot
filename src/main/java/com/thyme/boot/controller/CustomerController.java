package com.thyme.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thyme.boot.entities.Customer;
import com.thyme.boot.service.CustomerService;

/**
 * Controller is a class that controls every request 
 * from client and redirect to specific route ex: /route
 * 
 * @author joao.sanches
 *
 */
@Controller
public class CustomerController {
	
	private static final String PG_INDEX = "index";
	private static final String PG_CUSTOMERS = "customers";
	private static final String MESSAGE_SUCCESSFUL = "Customer was created successful";
	private static final String MESSAGE_KEY = "message";
	private static final String CUSTOMERS_OBJECT = "customers";
	
	@Autowired
	CustomerService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView(PG_INDEX);
		mv.addObject(new Customer());
		return mv;
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public ModelAndView saveCustomer(@Validated Customer customer, Errors errors){
		ModelAndView mv = new ModelAndView(PG_INDEX);
		if(errors.hasErrors()){
			return mv;
		}else{
			service.save(customer);
			customer = new Customer();
			mv.addObject(MESSAGE_KEY, MESSAGE_SUCCESSFUL);
		}
		return mv;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public ModelAndView listCustomers(){
		ModelAndView mv = new ModelAndView(PG_CUSTOMERS);
		List<Customer> customers = service.listCustomers();
		mv.addObject(CUSTOMERS_OBJECT, customers);
		return mv;
	}
	
}
