package com.example.demo.dao;

import com.example.demo.model.Faculty;
import org.springframework.data.repository.CrudRepository;

/**
 * @author I. Stetco
 */
public interface FacultyDao extends CrudRepository<Faculty, Integer> {
}
