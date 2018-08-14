package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ro.internteam.studypedia.dao.UniversityDao;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;

@Service
public class UniversityService {

    @Autowired
    private UniversityDao universityDao;

    public void saveUniversity(String universityName){
        University newUniversity = new University();
        newUniversity.setName(universityName);
        this.universityDao.save(newUniversity);
    }

    public Object getUniversities(){

        return this.universityDao.findAll();
    }

    public String insertFaculty(Integer universityId, String facultyName){
        University newUniversity = this.universityDao.findById(universityId).orElse(null);
        if(newUniversity != null){
            Faculty newFaculty = new Faculty();
            newFaculty.setName(facultyName);
            newUniversity.insertFaculty(newFaculty);
            return "added faculty " + facultyName;
        }
        return "University with id = " + universityId + " doesn't exist";
    }

}
