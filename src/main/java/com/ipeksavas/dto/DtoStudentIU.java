package com.ipeksavas.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { // insert ve update yaparken bu dto kullanilir.
	 @NotEmpty(message = "isim alanı boş bırakılamaz!")
//	 @Min(value = 3, message = "firstName minimum 3 karakter olabilir.")   sadece double, int, long gibi türlerde kullanılıyormuş 
//	 @Max(value = 10, message ="firstName maksimum 10 karakter olabilir.")
	 @Size(min = 3, max = 10, message = "firstName minimum 3 maksimum 10 karakter olabilir.")
	 private String firstName;
	
	 @Size(min = 3, max = 30, message = "lastName min 3 max 30 karaktere sahip olabilir.")
	 private String lastName;
	
	 private Date birthOfDate;
	 
	 //email ve tcNum verileri için veri tabanı tablosunda herhangi bir alan yok sadece validation kullanımı denenmek için eklendiler.
	 @Email(message = "Email formatında bir adres gir.")
	 private String email;
	 
	 @Size(min = 11, max=11, message = "tc kimlik numarası 11 karakter olmalıdır.")
	 @NotEmpty(message = "tc kimlik alanı boş bırakılamaz.")
	 private String tcNum;
}
