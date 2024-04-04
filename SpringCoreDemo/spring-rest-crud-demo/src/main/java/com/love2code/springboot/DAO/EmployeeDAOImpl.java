package com.love2code.springboot.DAO;

import com.love2code.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        //execute query and get result list
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee=entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee sEmployee=entityManager.merge(theEmployee);
        return sEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee dEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(dEmployee);

    }
}
