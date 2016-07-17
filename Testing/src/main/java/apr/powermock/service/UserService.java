package apr.powermock.service;

import apr.powermock.domain.User;

public interface UserService {

	User getUserById(Long userId);

	void updateUserDetails(User newUserDetails);

	void createUser(User user);

	Long getUserCount();

}