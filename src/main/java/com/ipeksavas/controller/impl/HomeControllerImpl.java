package com.ipeksavas.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipeksavas.controller.IHomeController;
import com.ipeksavas.dto.DtoHome;
import com.ipeksavas.service.IHomeService;


@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController{
	
	@Autowired
	private IHomeService homeService;
	
	@GetMapping(path = "/{id}")
	@Override
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		return homeService.findHomeById(id);
	}
	
}
