package com.ipeksavas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL) //bunun sayesinde değeri null olan veriler postmande gösterilmiyor
public class DtoCustomer {
	private Long id;
	
	private String name;
	
	private DtoAddress address;
}
