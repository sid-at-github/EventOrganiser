package projects.cloud.EventOrganiser.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projects.cloud.EventOrganiser.models.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	public List<User> findByEmailIgnoreCaseContaining(String email);

	public List<User> findByEmailAndPassword(String email, String password);

}
