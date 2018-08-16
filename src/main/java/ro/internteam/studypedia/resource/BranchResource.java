package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.service.BranchService;

@RestController
@CrossOrigin
public class BranchResource {


    @Autowired
    private BranchService branchService;

    @GetMapping(path = "/branch/all")
    public Object getBranches(){
        return this.branchService.getAllBranches();
    }

}
