package com.example.demo.dao;

import com.example.demo.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchDao extends CrudRepository<Branch, Integer> {
}
