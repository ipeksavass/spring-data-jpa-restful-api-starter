package com.ipeksavas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeksavas.dto.DtoStudent;
import com.ipeksavas.dto.DtoStudentIU;
import com.ipeksavas.entities.Student;
import com.ipeksavas.repository.StudentRepository;
import com.ipeksavas.services.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository; //repositorye baglandi
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);  // bizi set yapmaktan kurtariyor. Teker teker tum fieldlar icin set kullanmamis oluyoruz.
		//dto nesnesindeki bilgiler direkt veri tabanı entitysi olan studenta kopyalanir.
		Student dbStudent = studentRepository.save(student); //studentRepository sayesinde veritabanına kaydedilir


		BeanUtils.copyProperties(dbStudent, response);//Kaydedilen entity bilgileri → response DTO'ya aktarılıyor
		return response;//DTO olarak geri döndürülür
	}

	@Override 
	public List<DtoStudent> getAllStudents() {  //ogrenci listesini cekti
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> studentList = studentRepository.findAllStudents();//findAll(); vardı burada 
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student,dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getByStudentId(Integer id) {
		DtoStudent dto = new DtoStudent();
		Optional<Student> optional = studentRepository.findStudentById(id);//findById(id); vardı
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			BeanUtils.copyProperties(dbStudent, dto);
		}
		return dto;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional <Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
//		
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dto = new DtoStudent();

		Optional <Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
			
			Student updatedStudent =studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}
		
		
		return null;
	}

	
}
