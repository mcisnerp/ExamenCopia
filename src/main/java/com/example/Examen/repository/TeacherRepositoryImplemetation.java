package com.example.Examen.repository;


import com.example.Examen.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TeacherRepositoryImplemetation {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Teacher> findTeacherByAddress(String name,String Address){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher>teacherCriteriaQuery;
        return null;
    }
}
