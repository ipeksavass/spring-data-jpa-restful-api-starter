package com.ipeksavas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//veri tabanında bir tablo olabilmesi için işledim
@Table(name = "customer") //tablo adı customer olabilir
@Data
@NoArgsConstructor
@AllArgsConstructor

//Customerın bir adresi olmalı bunu belirtmek için de İLİŞKİLERDEN faydalanıcaz
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //idyi otomatik versin
	private Long id;
	
	@Column(name = "name")//kolon adı name
	private String name;
	
	
	//İLİŞKİNİN SAHİBİ
	@OneToOne
	private Address address;
	
}
