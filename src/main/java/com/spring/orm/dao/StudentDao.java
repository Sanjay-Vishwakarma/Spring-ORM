package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Student save
	@Transactional
	public int insert(Student student) {

		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get student single data
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	// get All students
	public List<Student> getAllStudents() {

		List<Student> loadAll = this.hibernateTemplate.loadAll(Student.class);
		return loadAll;

	}

	// delete data student
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);

		this.hibernateTemplate.delete(student);
	}

	// update student
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

	// update student @Transactional use for write operation
	//@Transactional
/*	public Student updateStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.update(student);
		return student;
	}*/

}
