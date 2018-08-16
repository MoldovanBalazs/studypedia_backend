package ro.internteam.studypedia.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.BranchDao;
import ro.internteam.studypedia.model.Branch;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.service.BranchService;

import java.util.List;

@RestController
@CrossOrigin
public class BranchResource {

    @Autowired
    BranchDao branchDao;

    @Autowired
    private BranchService branchService;

    @GetMapping(path = "/branch/all")
    public Object getBranches(){
        return this.branchService.getAllBranches();
    }

    @PostMapping(path = "/insertBranch")
    public void insertBranch(
            @RequestParam(name = "branchName") String branchName,
            @RequestParam(name = "faculty_id") Faculty faculty_id

    ){
        this.branchService.saveBranch(branchName, faculty_id);
    }

    @GetMapping(path = "/{facultyId}/branches")
    public List<Branch> getBranchesByFacultyId(@PathVariable Integer facultyId) {

        return branchDao.findAllByFacultyId(facultyId);
    }
}
