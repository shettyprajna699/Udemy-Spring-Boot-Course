package com.love2code.cruddemo;

import com.love2code.cruddemo.DAO.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = BatchAutoConfiguration.class)
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

     @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
		//	createStudent(studentDAO);
		//readStudent(studentDAO);
		//	queryForStudents(studentDAO);

		//	queryForByLastName(studentDAO);

		//	updateStudent(studentDAO);

		//	deleteStudent(studentDAO);
		
		deleteAlLStudents(studentDAO);
		};

	}

	private void deleteAlLStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("deleted row count: "+numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("deleting student id :"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
// retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("getting student with is "+ studentId);
		Student myStudent=studentDAO.findById(studentId);
		//change firstName to "scoby"
		System.out.println("Updating student..");
		myStudent.setFirstName("scooby");
		//update the student
		studentDAO.update(myStudent);
		//display the updated student
		System.out.println("updated student: "+myStudent);
	}

	private void queryForByLastName(StudentDAO studentDAO) {
		List<Student>theStudent=studentDAO.findByLastName("duck");
		for(Student student:theStudent){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();
		//display list of students
		for(Student student:theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("creating the student");
		Student student=new Student("daffy","duck","daffy@gmail.com");

		//save the student
		System.out.println("save the student object");
		studentDAO.save(student);
		//display id of the saved student
		int theId=student.getId();
		System.out.println("Saved student. generated id: "+theId);
		//retrieve student based on the id:primary key
		System.out.println("retrieving student with is id :"+ theId);
		Student myStudent=studentDAO.findById(theId);
		//display student
		System.out.println("found the student: "+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object..");
		Student student = new Student("ammu", "shree", "ammu@gmail.com");

		//saving the student object
		System.out.println("saving the student..");
		studentDAO.save(student);

		//display the id of saved student
		System.out.println("saved student Generated id: "+ student.getId()
		);
	}
}