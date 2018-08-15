package ro.internteam.studypedia.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.BranchDao;
import ro.internteam.studypedia.model.Branch;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.service.BranchService;

@RestController
@CrossOrigin
public class BranchResource {

    @Autowired
    BranchDao branchDao;

    @Autowired
    BranchService branchService;

    @PostMapping(path = "/insertBranch")
    public void insertBranch(
            @RequestParam(name = "branchName") String branchName,
            @RequestParam(name = "faculty_id") Faculty faculty_id

    ){
        this.branchService.saveBranch(branchName, faculty_id);
    }
}
