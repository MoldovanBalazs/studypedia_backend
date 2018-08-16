package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.internteam.studypedia.dao.BranchDao;

@Service
public class BranchService {

    @Autowired
    private BranchDao branchDao;

    public Object getAllBranches(){return this.branchDao.findAll();}

}
