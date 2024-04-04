package com.love2code.DAO;

import com.love2code.entity.Course;
import com.love2code.entity.Instructor;
import com.love2code.entity.InstructorDetails;
import com.love2code.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor=entityManager.find(Instructor.class,theId);
       //get the courses
       List<Course> courses=theInstructor.getCourses();
        //break association of all courses for the instructor
        for(Course tempCourse:courses){
            tempCourse.setInstructor(null);
        }


        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetails.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetails instructorDetails=entityManager.find(InstructorDetails.class,theId);
        instructorDetails.getTheInstructor().setInstructorDetails(null);
        entityManager.remove(instructorDetails);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "from Course where instructor.id= :data",Course.class
        );
        query.setParameter("data",theId);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query
        TypedQuery<Instructor> query=entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses "+
                        "JOIN FETCH i.instructorDetail "+
                        "where i.id= :data",Instructor.class);
        query.setParameter("data",theId);
        Instructor theinstructor=query.getSingleResult();
        return theinstructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse=entityManager.find(Course.class,theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);


    }

    @Override
    public Course findcourseAndReviewsByCourseId(int theId) {
        //create query
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
                +"where c.id= :data", Course.class
        );
        query.setParameter(
                "data",theId
        );
        //execute query
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c "
                        +"JOIN FETCH c.students "
                        +"where c.id= :data", Course.class
        );
        query.setParameter(
                "data",theId
        );

        Course course=query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        //create query
        TypedQuery<Student> query=entityManager.createQuery(
                "select s from Student s "
                +"JOIN FETCH s.courses "
                +"where s.id= :data",Student.class);
        query.setParameter("data",theId);
        Student students=query.getSingleResult();
        return students;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void deleteStudentById(int theID) {
        //retrieve the student
        Student theStudent=entityManager.find(Student.class,theID);
        entityManager.remove(theStudent);
    }
}
