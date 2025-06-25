package com.ipeksavas.controller;

import java.util.List;

import com.ipeksavas.dto.DtoEmployee;

public interface IEmployeeController {
	public List<DtoEmployee> findAllEmployees();
}
