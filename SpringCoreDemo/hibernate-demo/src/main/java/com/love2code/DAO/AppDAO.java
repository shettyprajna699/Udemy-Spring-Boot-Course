package com.love2code.DAO;

import com.love2code.entity.Course;
import com.love2code.entity.Instructor;
import com.love2code.entity.InstructorDetails;
import com.love2code.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
    InstructorDetails findInstructorDetailById(int theId);

    void deleteInstructorDetailsById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
    void updateCourse(Course course);

    Course findCourseById(int theId);
    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findcourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student theStudent);

    void deleteStudentById(int theID);

}
