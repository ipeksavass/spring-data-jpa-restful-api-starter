package com.ipeksavas.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {//pring’in tüm controller’larında oluşabilecek hataları yakalamak için kullanılan yapı.
	//spring validationdan dönen hataları yakalayıp yöneterek anlamlı hata açıklamaları dönmek için alıştırma.
	
	private List<String> addMapValue(List<String> list, String newValue){//Mevcut bir listeye yeni hata mesajı eklemek için kullanılan basit yardımcı metot.
		list.add(newValue);
		return list;
	}
	
	//@Valid anotasyonlu DTO'lardaki kurallar ihlal edilirse Spring bu hatayı fırlatır. Burada yakalanır.
	@ExceptionHandler(value = MethodArgumentNotValidException.class)//fırlatılan MethodArgumentNotValidException hatasını yakaladı exception handler
	                                                               //daha sonra aşağıdaki fonk a soktu
	public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		// Hatalar döngüyle gezilir, hangi alan (fieldName) hatalıysa onun adı alınır.
		Map<String, List<String>> errorsMap = new HashMap<>();
		for (ObjectError objErr : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError)objErr).getField();
			
			// Eğer o alan zaten Map içinde varsa, mevcut listeye ek yapılır. Yoksa yeni liste oluşturulur.
			if(errorsMap.containsKey(fieldName)) {
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objErr.getDefaultMessage()));
			}else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objErr.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap));//ApiError nesnesi oluştur ve cevabı dön
	}
	
	
	// Generic olarak ApiError nesnesi oluşturur ve Map ya da başka türde hataları içine koyar.
	private <T> ApiError<T> createApiError(T errors) {  //1. <T> generic oldugunu ifade ediyor sadece.
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		
		return apiError;
	}
}
