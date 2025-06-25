package com.ipeksavas.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {  //bu get islemlerinde kullanilir clienta tum fieldlari gondermek istemiyoruz.
	 private Integer id;
	 private String firstName;
	 private String lastName;
	 private List<DtoCourse> courses = new ArrayList<>();

}
