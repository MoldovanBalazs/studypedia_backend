package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchDao extends CrudRepository<Branch, Integer> {
}
