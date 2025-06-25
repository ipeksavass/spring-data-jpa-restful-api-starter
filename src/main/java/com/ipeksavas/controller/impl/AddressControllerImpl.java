package com.ipeksavas.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipeksavas.controller.IAddressController;
import com.ipeksavas.dto.DtoAddress;
import com.ipeksavas.service.IAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController{

	@Autowired
	private IAddressService addressService;
	
	@GetMapping(path ="/list/{id}")
	@Override
	public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
		return addressService.findAddressById(id);
	}

}
