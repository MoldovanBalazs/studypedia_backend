package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
