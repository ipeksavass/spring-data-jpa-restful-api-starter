package com.ipeksavas.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipeksavas.controller.ICustomerController;
import com.ipeksavas.dto.DtoCustomer;
import com.ipeksavas.service.ICustomerService;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return customerService.findCustomerById(id);
	}

	

}
