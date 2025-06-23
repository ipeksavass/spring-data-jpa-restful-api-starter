package com.ipeksavas.controller;

import java.util.List;

import com.ipeksavas.dto.DtoStudent;
import com.ipeksavas.dto.DtoStudentIU;

public interface IStudentController {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> getAllStudents();
	public DtoStudent getByStudentId(Integer id);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
	
}
