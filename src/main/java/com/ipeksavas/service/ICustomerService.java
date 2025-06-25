package com.ipeksavas.service;

import com.ipeksavas.dto.DtoCustomer;

public interface ICustomerService {
	public DtoCustomer findCustomerById(Long id);
}
