package com.love2code.cruddemo.DAO;

import com.love2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    @Autowired
      private EntityManager entityManager;
      public StudentDAOImpl(){

      }

//inject entity manager using constructor injection
//    public StudentDAOImpl(EntityManager entityManager) {
//
//        this.entityManager = entityManager;
//    }
//implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
          //cretae query
        TypedQuery<Student> thequery=entityManager.createQuery("from student order by lastName", Student.class);

        return thequery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
          TypedQuery<Student> thequery=entityManager.createQuery("from student where lastName=:theData",Student.class);
          //set Query parameters
        thequery.setParameter("theData",lastName);
        //return query parameters
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student mystudent=entityManager.find(Student.class,id);
        entityManager.remove(mystudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
          int numRowsDeleted=entityManager.createQuery("DELETE from student").executeUpdate();
          return numRowsDeleted;
    }
}
