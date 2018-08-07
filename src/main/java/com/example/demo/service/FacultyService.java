package com.example.demo.service;

import com.example.demo.dao.FacultyDao;
import com.example.demo.dao.UniversityDao;
import com.example.demo.model.Faculty;
import com.example.demo.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    @Autowired
    FacultyDao facultyDao;

    @Autowired
    UniversityDao universityDao;

    public void saveFaculty(String name, String universityName){
        University university = universityDao.findById(1).orElse(null);
        if(university == null){
            return;
        }
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setUniversity(university);
        facultyDao.save(faculty);
    }
}
