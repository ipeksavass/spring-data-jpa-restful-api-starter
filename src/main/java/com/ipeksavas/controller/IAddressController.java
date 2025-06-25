package com.ipeksavas.controller;

import com.ipeksavas.dto.DtoAddress;

public interface IAddressController {
	public DtoAddress findAddressById(Long id);
}
