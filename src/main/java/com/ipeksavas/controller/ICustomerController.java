package com.ipeksavas.controller;

import com.ipeksavas.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);
}
