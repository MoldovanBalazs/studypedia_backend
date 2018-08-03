package com.example.demo.dao;

import com.example.demo.model.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityDao extends CrudRepository<University, Integer> {
}
