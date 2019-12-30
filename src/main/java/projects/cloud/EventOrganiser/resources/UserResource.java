package projects.cloud.EventOrganiser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projects.cloud.EventOrganiser.daos.UserDao;
import projects.cloud.EventOrganiser.dtos.ResponseDto;
import projects.cloud.EventOrganiser.dtos.UserRequestDto;
import projects.cloud.EventOrganiser.models.User;

@RestController
public class UserResource {

	@Autowired
	private UserDao userDao;

	@PostMapping("/user")
	public ResponseDto createUser(@RequestBody User user) {
		userDao.save(user);
		return new ResponseDto("success");
	}

	@GetMapping("/user")
	public List<User> getUser(UserRequestDto userRequestDto) {
		if (userRequestDto.getPassword() == null) {
			return userDao.findByEmailIgnoreCaseContaining(userRequestDto.getEmail());
		}
		return userDao.findByEmailAndPassword(userRequestDto.getEmail(), userRequestDto.getPassword());
	}
}
