package com.ipeksavas.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipeksavas.controller.IStudentController;
import com.ipeksavas.dto.DtoStudent;
import com.ipeksavas.dto.DtoStudentIU;
import com.ipeksavas.services.IStudentService;

@RestController //Controller oldugunu soylemek icin 
@RequestMapping("/rest/api/student")  //base bir url tanimladik
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path ="/save")      //post islemi gerceklestirecegim icin ekledim 
	@Override
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getByStudentId(@PathVariable(name = "id")Integer id) {
		return studentService.getByStudentId(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")  //guncellemeler icin put kullaniyoruz
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id")Integer id,@RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.updateStudent(id, dtoStudentIU);
	}

	
	
}
