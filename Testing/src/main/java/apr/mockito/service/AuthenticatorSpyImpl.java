package apr.mockito.service;

import apr.mockito.service.exception.EmptyCredentialsException;
import apr.mockito.service.exception.NotAuthenticatedException;

public class AuthenticatorSpyImpl implements Authenticator {

	public boolean authenticateUser(String username, String password) throws EmptyCredentialsException {
		return true;
	}

	public void foo() throws EmptyCredentialsException {
		throw new UnsupportedOperationException("Not implemented");
	}

	public void authenticateUserVoid(String username, String password) throws NotAuthenticatedException {
		throw new UnsupportedOperationException("Not implemented");
	}

	public boolean isAuthenticate() {
		return true;
	}

}
