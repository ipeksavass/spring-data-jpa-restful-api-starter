package com.ipeksavas.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipeksavas.configuration.DataSource;
import com.ipeksavas.configuration.GlobalProperties;
import com.ipeksavas.configuration.Server;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		
		return null;
	}
	@GetMapping("/getServers")
	public List<Server> getServers(){
		System.out.println("key degerim:"+ globalProperties.getKey());
		return globalProperties.getServers();
	}
	
}
