package com.ipeksavas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ipeksavas.entities.Student;

@Repository //repository beani olustu 
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	//sorgu  HQL ile yazılır Student classı veriyoruz.
	//HQL : sınıfın ismi ve değişkenleri kullanılarak sorgular yazılır nativeQuery = false
	//SQL : veri tabanındaki tablo ismi ve tablonun kolon isimleri ile sorgu yazılır nativeQuery = true
	//Query(value = "from Student", nativeQuery = false)
	@Query(value = "select * from student.student",nativeQuery = true)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s where s.id = :studentId")
	Optional<Student> findStudentById(Integer studentId );
}
