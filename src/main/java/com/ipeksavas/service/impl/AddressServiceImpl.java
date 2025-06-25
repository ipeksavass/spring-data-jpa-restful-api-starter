package com.ipeksavas.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeksavas.dto.DtoAddress;
import com.ipeksavas.dto.DtoCustomer;
import com.ipeksavas.entities.Address;
import com.ipeksavas.repository.AddressRepository;
import com.ipeksavas.service.IAddressService;


@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById(Long id) {
		DtoAddress dtoAddress = new DtoAddress(); //1.PARÇA
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isEmpty()) {
			return null;	
		}
		Address address = optional.get();
		BeanUtils.copyProperties(address, dtoAddress);
		
		DtoCustomer dtoCustomer = new DtoCustomer();  //2.PARÇA
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());
		
//		dtoCustomer.setAddress(dtoAddress);
		
		dtoAddress.setCustomer(dtoCustomer);//1.PARÇANIN İÇİNE 2. PARÇAYI KOYUYOR
		
	return dtoAddress;//1.PARÇAYI DA DÖNDÜRÜYOR
	}

}
