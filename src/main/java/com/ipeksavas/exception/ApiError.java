package com.ipeksavas.exception;


import java.util.Date;  // şuna dikkat et .sql.Date alınca uyumsuzluktan hata veriyor
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {  // Generic (esnek) hata sınıfı. T tipi, içeriğini dinamik yapıyor.
	private String id;// Her hata için rastgele bir ID (takip etmek kolay olsun diye).
	private Date errorTime;//Hatanın oluştuğu zaman.
	private T errors;// Hataların kendisi. Bu, genellikle Map<String, List<String>> tipinde geliyor.
}
