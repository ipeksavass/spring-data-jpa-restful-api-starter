package com.ipeksavas.service;

import java.util.List;

import com.ipeksavas.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> findAllEmployees();
}
