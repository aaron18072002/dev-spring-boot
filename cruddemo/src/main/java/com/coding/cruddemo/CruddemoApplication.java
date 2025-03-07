package com.coding.cruddemo;

import com.coding.cruddemo.dao.StudentDAO;
import com.coding.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

			readStudent(studentDAO);
		};
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
