package com.faculty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faculty.entity.Emp;

// This will be AUTO IMPLEMENTED by Spring into a Bean called EmpRepository
// CRUD refers Create, Read, Update, Delete
//@Repository
public interface EmpRepository extends CrudRepository<Emp, Integer> {

}