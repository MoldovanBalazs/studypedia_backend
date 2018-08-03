package com.example.demo.dao;

import com.example.demo.model.Deadline;
import org.springframework.data.repository.CrudRepository;

public interface DeadlineDao extends CrudRepository<Deadline, Integer> {
}
