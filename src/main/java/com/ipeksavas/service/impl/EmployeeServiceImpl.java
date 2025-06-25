package com.ipeksavas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeksavas.dto.DtoDepartment;
import com.ipeksavas.dto.DtoEmployee;
import com.ipeksavas.entities.Employee;
import com.ipeksavas.repository.EmployeeRepository;
import com.ipeksavas.service.IEmployeeService;

@Service//beanin oluşmasını sağladık
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<DtoEmployee> findAllEmployees() {
		
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>(); 
		List<Employee> employeeList = employeeRepository.findAll();
		if(employeeList != null && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);

				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),
						employee.getDepartment().getDepartmentName()));
				
				dtoEmployeeList.add(dtoEmployee);
			}
		}
		return dtoEmployeeList;
	}

}
