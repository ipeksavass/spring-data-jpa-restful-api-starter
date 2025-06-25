package com.ipeksavas.service;

import java.util.List;

import com.ipeksavas.dto.DtoStudent;
import com.ipeksavas.dto.DtoStudentIU;

public interface IStudentService {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> getAllStudents();
	public DtoStudent getByStudentId(Integer id);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);//insert, update islemlerinde bu dto kullaniliyor.
}

