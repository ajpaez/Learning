package apr.mockito.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import apr.mockito.service.exception.EmptyCredentialsException;
import apr.mockito.service.exception.NotAuthenticatedException;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorImplTest {

	/**
	 * Con la anotacion @Mock definimos las dependencias para inyectar.
	 * Con @InjectMocks indicamos donde inyectarlas las dependencias.
	 * Solo con estas anotaciones tenemos una instancia de Authenticator y 
	 * AuthenticatorImpl inyectadas. 
	 * Para llevar a cabo la inyeccion, Mockito usa el constructor, el setter o el campo
	 * de la clase, si la inyeccion falla el resultado será una referencia nula.
	 */
	@Mock
	private Authenticator authenticatorMock;

	@InjectMocks
	private AuthenticatorImpl authenticatorImpl;

	@Test
	public void testAuthenticateUserFail_OK() throws EmptyCredentialsException {
		Authenticator authenticatorMock;
		AuthenticatorImpl authenticatorImpl;
		String username = "JavaCodeGeeks";
		String password = "unsafePassword";

		authenticatorMock = Mockito.mock(Authenticator.class);
		authenticatorImpl = new AuthenticatorImpl(authenticatorMock);

		Mockito.when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);

		boolean actual = authenticatorImpl.authenticate(username, password);

		Assert.assertFalse(actual);

		Mockito.verify(authenticatorMock).authenticateUser(username, password);
		Mockito.verify(authenticatorMock, Mockito.times(1)).authenticateUser(username, password);
		Mockito.verify(authenticatorMock, Mockito.atLeastOnce()).authenticateUser(username, password);
		Mockito.verify(authenticatorMock, Mockito.atLeast(1)).authenticateUser(username, password);
		Mockito.verify(authenticatorMock, Mockito.atMost(1)).authenticateUser(username, password);
		Mockito.verify(authenticatorMock, Mockito.times(0)).authenticateUser(username, "otra clase");

	}

	@Test(timeout = 100)
	public void testJUnitTimeout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {

		}
	}

	@Test
	public void testAuthenticate2_Fail_OK_CheckOrder() throws EmptyCredentialsException, InterruptedException {
		Authenticator authenticatorMock;
		AuthenticatorImpl authenticatorImpl;
		String username = "JavaCodeGeeks";
		String password = "unsafePassword";

		authenticatorMock = Mockito.mock(Authenticator.class);
		authenticatorImpl = new AuthenticatorImpl(authenticatorMock);

		Mockito.when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);

		boolean actual = authenticatorImpl.foo_Authenticate(username, password);

		Assert.assertFalse(actual);

		// verificacion del orden
		InOrder inOrder = Mockito.inOrder(authenticatorMock);
		inOrder.verify(authenticatorMock).foo();
		inOrder.verify(authenticatorMock).authenticateUser(username, password);

		// verificacion del tiempo de ejecucion y num veces ejecutadas
		Mockito.verify(authenticatorMock, Mockito.timeout(1000).times(1)).authenticateUser(username, password);
	}

	@Test(expected = EmptyCredentialsException.class)
	public void testAuthenticateEmptyCredentialsException_KO() throws EmptyCredentialsException {
		Authenticator authenticatorMock;
		AuthenticatorImpl authenticatorImpl;

		authenticatorMock = Mockito.mock(Authenticator.class);
		authenticatorImpl = new AuthenticatorImpl(authenticatorMock);

		Mockito.when(authenticatorMock.authenticateUser("", "")).thenThrow(new EmptyCredentialsException());

		authenticatorImpl.authenticate("", "");
	}
	
	@Test
	public void testAuthenticate_OK_MockInjection() throws EmptyCredentialsException {
	    String username = "javacodegeeks";
	    String password = "s4f3 p4ssw0rd";

	    Mockito.when(this.authenticatorMock.authenticateUser(username, password))
	        .thenReturn(true);

	    boolean actual = this.authenticatorImpl.authenticate("javacodegeeks", "s4f3 p4ssw0rd");
	        
	    Assert.assertTrue(actual);
	}

	@Test(expected = NotAuthenticatedException.class)
    public void testAuthenticateVoid() throws NotAuthenticatedException, EmptyCredentialsException {
        String username = "JavaCodeGeeks";
        String password = "wrong password";

        Mockito.doThrow(new NotAuthenticatedException())
            .when(authenticatorMock)
            .authenticateUserVoid(username, password);
        
        this.authenticatorImpl.authenticateVoid(username, password);
    }
	
	@Test
    public void authenticatorSpyTest() {        
        Authenticator authenticateMock = Mockito.spy(new AuthenticatorSpyImpl());
        Assert.assertTrue(authenticateMock.isAuthenticate());
        Mockito.when(authenticateMock.isAuthenticate()).thenReturn(false);
        Assert.assertFalse(authenticateMock.isAuthenticate());
    }
}
