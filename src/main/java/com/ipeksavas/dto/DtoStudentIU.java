package com.ipeksavas.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { // insert ve update yaparken bu dto kullanilir.
	 private String firstName;
	 private String lastName;
	 private Date birthOfDate;
}
