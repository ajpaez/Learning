package apr.mockito.service;

import apr.mockito.service.exception.EmptyCredentialsException;
import apr.mockito.service.exception.NotAuthenticatedException;

public class AuthenticatorImpl {

	private Authenticator authenticator;

	/**
	 * AuthenticatorApplication constructor.
	 *
	 * @param authenticator
	 *            Authenticator interface implementation.
	 */
	public AuthenticatorImpl(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	/**
	 * Tries to authenticate an user with the received user name and password,
	 * with the received AuthenticatorInterface interface implementation in the
	 * constructor.
	 *
	 * @param username
	 *            The user name to authenticate.
	 * @param password
	 *            The password to authenticate the user.
	 * @return True if the user has been authenticated; false if it has not.
	 */
	public boolean authenticate(String username, String password)  throws EmptyCredentialsException{
		boolean authenticated;

		authenticated = this.authenticator.authenticateUser(username, password);

		return authenticated;
	}

	public boolean authenticate2(String username, String password) throws EmptyCredentialsException, InterruptedException {
		boolean authenticated;

		this.authenticator.foo();
		authenticated = this.authenticator.authenticateUser(username, password);

		return authenticated;
	}
	
	/**
     * Tries to authenticate an user with the received user name and password, with the received
     * AuthenticatorInterface interface implementation in the constructor.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @throws NotAuthenticatedException If the user can't be authenticated.
	 * @throws EmptyCredentialsException 
     */
    public void authenticateVoid(String username, String password) throws NotAuthenticatedException {
        this.authenticator.authenticateUserVoid(username, password);
    }
    
    public boolean isAuthenticate(){
    	return true;
    }

}
