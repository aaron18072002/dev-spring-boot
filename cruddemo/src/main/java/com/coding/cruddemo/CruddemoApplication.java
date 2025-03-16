package com.coding.cruddemo;

import com.coding.cruddemo.dao.StudentDAO;
import com.coding.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

//			readStudent(studentDAO);

//			readAllStudents(studentDAO);

//			this.readStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	public void deleteAllStudents(StudentDAO studentDAO) {
		int rows = studentDAO.deleteAll();
		System.out.println("Số Students đã xóa: " + rows);
	}

	public void deleteStudent(StudentDAO studentDAO) {
		int rows = studentDAO.deleteById(3);
		System.out.println("Số Students đã xóa: " + rows);
	}

	public void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Scooby");
		student.setLastName("Doo");
		student.setEmail("scooby@doo.com");
		studentDAO.update(student);
		Student updatedStudent = studentDAO.findById(student.getStudentId());
		System.out.println("Student updated: " + updatedStudent);
	}

	public void readStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Get Students by lastName --> [");
		List<Student> students = studentDAO.findByLastName("Duck");
		for(Student student : students) {
			System.out.println("\t" + student);
		}
		System.out.println("]");
	}

	public void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Get all Students --> [");
		List<Student> students = studentDAO.findAll();
		for(Student student : students) {
			System.out.println("\t" + student);
		}
		System.out.println("]");
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student student = new Student();
		student.setFirstName("Daffy");
		student.setLastName("Duck");
		student.setEmail("daffy@duck.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println("Retriving the student");
		Integer studentId = student.getStudentId();
		Student studentFromDb = studentDAO.findById(studentId);

		System.out.println("Displaying the student");
		System.out.println(studentFromDb.toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Create Student object");
		Student student = new Student();
		student.setFirstName("Paul");
		student.setLastName("Doe");
		student.setEmail("paul@doe.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated studentId: " + student.getStudentId());

	}

}
