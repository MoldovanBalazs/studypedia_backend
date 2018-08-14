package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {

    public User findAllByUsername(String username);
}
