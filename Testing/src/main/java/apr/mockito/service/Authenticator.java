package apr.mockito.service;

import apr.mockito.service.exception.EmptyCredentialsException;
import apr.mockito.service.exception.NotAuthenticatedException;

public interface Authenticator {

	/**
	 * User authentication method definition.
	 *
	 * @param username
	 *            The user name to authenticate.
	 * @param password
	 *            The password to authenticate the user.
	 * @return True if the user has been authenticated; false if it has not.
	 * @throws EmptyCredentialsException
	 *             If the received credentials (user name, password) are empty.
	 */
	public boolean authenticateUser(String username, String password) throws EmptyCredentialsException;

	public void foo() throws EmptyCredentialsException;

	public void authenticateUserVoid(String username, String password) throws NotAuthenticatedException;

	public boolean isAuthenticate();
}
