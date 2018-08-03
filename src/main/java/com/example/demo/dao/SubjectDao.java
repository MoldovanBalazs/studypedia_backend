package com.example.demo.dao;

import com.example.demo.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDao extends CrudRepository<Subject, Integer> {
}
