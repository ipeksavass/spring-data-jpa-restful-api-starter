package com.ipeksavas.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSource {//DataSource sınıfı, bu verileri dışarıya sade şekilde taşımak için kullanıldı.

	private String url;
	private String username;
	private String password;
}
