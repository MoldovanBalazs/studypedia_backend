package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.BranchDao;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.model.*;
import org.springframework.stereotype.Service;

@RestController
@CrossOrigin
@Service
public class BranchService {

    @Autowired
    private BranchDao branchDao;

    public Object getAllBranches(){return this.branchDao.findAll();}
    @Autowired
    private FacultyDao facultyDao;

    public void saveBranch(String branchName, Faculty faculty){
        Branch newBranch = new Branch();
        newBranch.setName(branchName);
        newBranch.setFaculty(faculty);
        this.branchDao.save(newBranch);
    }



}
