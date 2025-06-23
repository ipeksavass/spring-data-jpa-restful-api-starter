package com.ipeksavas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {  //bu get islemlerinde kullanilir clienta tum fieldlari gondermek istemiyoruz.
	 private String firstName;
	 private String lastName;

}
