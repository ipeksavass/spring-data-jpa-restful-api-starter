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
@Table(name = "address") //tablo adı customer olabilir
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="description")
	private String description;
	
	
	//İLİŞKİNİN SAHİBİ DEĞİL
	@OneToOne(mappedBy = "address")
	private Customer customer;
}
