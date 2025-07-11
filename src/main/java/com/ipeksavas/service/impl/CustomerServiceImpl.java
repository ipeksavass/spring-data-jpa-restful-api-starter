package com.ipeksavas.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeksavas.dto.DtoAddress;
import com.ipeksavas.dto.DtoCustomer;
import com.ipeksavas.entities.Address;
import com.ipeksavas.entities.Customer;
import com.ipeksavas.repository.CustomerRepository;
import com.ipeksavas.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional<Customer> optional =customerRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Customer customer = optional.get();
		Address address =optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		dtoCustomer.setAddress(dtoAddress);
		return dtoCustomer;
	}
	
}
