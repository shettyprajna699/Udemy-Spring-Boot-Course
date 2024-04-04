package com.love2code;

import com.love2code.DAO.AppDAO;
import com.love2code.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourse(appDAO);
			//createCourseAndReviews(appDAO);
			//retrieveCourseAndReviews(appDAO);
			//deleteCourseAndReviews(appDAO);
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting the student "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("done");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(theId);
		Course tempCourse=new Course("AWS for beginners");
		Course tempCourse1=new Course("Deep Learning");
		tempStudent.addCourse(tempCourse);
		tempStudent.addCourse(tempCourse1);
		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("done");
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId=1;
		Student theStudent=appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded Student: "+theStudent);
		System.out.println("Associated courses: "+theStudent.getCourses());
		System.out.println("Done");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		System.out.println("done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		//create a course
		Course tempCourse=new Course("Azure Fundamentals");
		//create the students
		Student theStudent=new Student("Prajna","shetty","prajna@gmail.com");
		Student theStudent1=new Student("Pravi","rai","pravi@gmail.com");
		Student theStuden2=new Student("Pragathi","jain","pragathi@gmail.com");

		//add students to the course
		tempCourse.addStudent(theStudent);
		tempCourse.addStudent(theStudent1);
		tempCourse.addStudent(theStuden2);
		//save the course and associated students
		System.out.println("saving the course: "+tempCourse);
		System.out.println("associated students: "+ tempCourse.getStudents());
		appDAO.save(tempCourse);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=12;
		System.out.println("deleting the course"+theId);
		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
	//get the course and reviews
		int theId=12;
		Course tempCourse=appDAO.findcourseAndReviewsByCourseId(theId);

		//print the course
		System.out.println(tempCourse);
		//print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		//create a course
		Course tempCourse=new Course("Azure AI fundamentals");
		//add some reviews
		tempCourse.addReview(new Review("Greate Course...loved it"));
		tempCourse.addReview(new Review("Too much lengthy course"));
		tempCourse.addReview(new Review("Very good explanation I understood very well"));
		tempCourse.addReview(new Review("crystal and clear"));
		//save the course
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Delete the course "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Finding course id "+theId);
		Course tempCourse=appDAO.findCourseById(theId);
		System.out.println("Updating course id:"+theId);
		tempCourse.setTitle("Happy Java");
		appDAO.updateCourse(tempCourse);
		System.out.println("done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id: "+theId);
		Instructor tempInst=appDAO.findInstructorById(theId);
		System.out.println("updating instrucot id:"+theId);
		tempInst.setLastName("alva");
		appDAO.update(tempInst);
		System.out.println("done!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor is: "+theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding the Instructor Id: "+ theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor "+tempInstructor);
		//find courses for instructor
		System.out.println("finding courses for instructor id "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses:"+tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding the Instructor Id: "+ theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor "+tempInstructor);
		System.out.println("The associated Courses: "+tempInstructor.getCourses());
		System.out.println("done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=
				new Instructor("avinavu","rai","avinavu@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("http;//udemy.com","learner");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		Course tempCourse=new Course("Spring Boot 3 for Beginners");
		Course tempCourse2=new Course("Java 8 for Beginners");
		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse2);
		//save the instructor
		System.out.println("Saving instructor "+ tempInstructor);
		System.out.println("The courses"+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("DOne");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Delete The Instructor Details:"+theId);
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		//get the instructor detail object
		int theId=2;
		InstructorDetails tempInstructorDetail=appDAO.findInstructorDetailById(theId);
		//print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		//print the associated instructor
		System.out.println("the associated instructor "+tempInstructorDetail);

		System.out.println("Done");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Delete the instructor"+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor "+tempInstructor);
		System.out.println("the associated instructor only: "+tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDAO appDAO){
		Instructor tempInstructor=
				new Instructor("abhi","patil","abhi@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("http://www.luv2code.com/youtube","luv 2 code");
		//associate the objects

		tempInstructor.setInstructorDetails(tempInstructorDetails);

		//save the instructor
		// This will also save the details object because of CascadeType.ALL
		System.out.println("Saving Instructor" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("done");

	}
}
