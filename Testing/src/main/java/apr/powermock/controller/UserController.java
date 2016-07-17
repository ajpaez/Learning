package apr.powermock.controller;

import java.util.UUID;

import apr.powermock.domain.User;
import apr.powermock.service.UserService;

/**
 * Controller class handling the user operations
 * 
 * @author Meraj
 *
 */
public class UserController {

	private UserService userService;

	public UserController() {

	}

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public Long getUserCount() {
		return userService.getUserCount();
	}

	public String createUserId(User user) {
		return String.format("%s_%s", user.getSurname(), UUID.randomUUID().toString());
	}

	public String getGreetingText(User user) {
		return String.format(getGreetingFormat(), user.getFirstName(), user.getSurname());
	}

	private String getGreetingFormat() {
		return "Hello %s %s";
	}
}
