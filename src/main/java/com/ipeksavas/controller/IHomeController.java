package com.ipeksavas.controller;

import com.ipeksavas.dto.DtoHome;

public interface IHomeController {
	public DtoHome findHomeById(Long id);
}
