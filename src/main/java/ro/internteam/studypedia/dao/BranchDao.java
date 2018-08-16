package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Branch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BranchDao extends CrudRepository<Branch, Integer> {

    public List<Branch> findAllByFacultyId(Integer facultyId);
}
