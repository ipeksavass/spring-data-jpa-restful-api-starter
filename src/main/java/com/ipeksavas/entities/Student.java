package com.ipeksavas.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Data da getter ve setter birleşimi
public class Student {
	
	@Id  //idyi primary key olarak ekle demiş oldum.
	@Column (name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "first_name", nullable = false)
	private String firstName;
	
	@Column (name = "last_name", nullable = false)
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column (name = "birth_of_date", nullable = true)
	private Date birthOfDate;
}
