package apr.powermock.controller;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import apr.powermock.domain.User;
import apr.powermock.service.UserServiceImpl;

/**
 * Cuando una clase es anotada con @RunWith o extiende de una clase anotada
 * con @RunWith, JUnit invocara las clases referencidas para ejecutar los test
 * en lugar de ejecutarlos conJUnit. Para nuestros ejemplos vamos a utilizar la
 * clase org.powermock.modules.junit4.PowerMockRunner para ejecutar los test.
 * Crearemos un mock de DefaultUSerService llamando al metodo mock de la clase
 * org.powermock.api.mockito.PowerMockito
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserController.class, UUID.class })
public class UserControllerTest {

	private UserServiceImpl mockUserService;

	/**
	 * Test para metodo public, nada especial
	 */
	@Test
	public void testGetUserCount() {
		mockUserService = PowerMockito.mock(UserServiceImpl.class);
		PowerMockito.when(mockUserService.getUserCount()).thenReturn(100L);
		UserController userController = new UserController(mockUserService);
		assertEquals(100L, userController.getUserCount().longValue());
	}

	/**
	 * Test para metodo estatico en clase final. Vamos a utilizar la clase java.util.UUID para
	 * esto. Un UUID representa un identificador único universal inmutable (de
	 * 128 bits). En esta clase hay un método llamado randomUUID() estatico. Se
	 * utiliza para recuperar un UUID de tipo 4 (pseudo generado
	 * aleatoriamente). El UUID se genera utilizando un generador de números
	 * aleatorios pseudo criptográficamente fuerte. Vamos a crear un método
	 * simple en la clase UserController para usar este metodo y crear al azar
	 * un id de de usuario. Para este test haremos uso de EasyMock que nos
	 * permite hacer mock de la clase final UUID y poder hacer llamadas a su
	 * metodo randomUUID
	 */

	@Test
	public void testMockStatic() throws Exception {

		// Llamada a mockStaticPartial con la clase y el nombre del metodo
		// estatico que se quiere hacer mock
		PowerMock.mockStaticPartial(UUID.class, "randomUUID");

		// Se define el valor que se desea devolver cuando se realice la llamada
		// al metodo estatico
		EasyMock.expect(UUID.randomUUID()).andReturn(UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00"));

		// A continuacion se reproducen todas las clases y objetos mock
		// conocidos por PowerMock.
		// Esto incluye todas las anotadas con Prepare ForTest or
		// PrepareOnlyThisForTest
		// tambien incluye todas las clases mock instancias por PowerMock, como
		// las creadas o usadas por:
		// createMock(Class, Method...), mockStatic(Class, Method...),
		// expectNew(Class, Object...), createPartialMock(Class, String...) etc.
		PowerMock.replayAll();
		UserController userController = new UserController(mockUserService);
		Assert.assertTrue(userController.createUserId(getNewUser()).contains("067e6162-3b6f-4ae2-a171-2470b63dff00"));
		PowerMock.verifyAll();
	}

	/**
	 * En este test veremos como hacer mock de metodos privados. Para ello crearemos un
	 * objeto spy del objeto real. Cuando se usa un spy se llaman a los metodos
	 * reales( a menos que se haga un stub del metodo) Spying en los metodos
	 * reales se puede asocias con el concepto de mock parcial.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMockPrivateMethod() throws Exception {
		UserController spy = PowerMockito.spy(new UserController());
		PowerMockito.when(spy, MemberMatcher.method(UserController.class, "getGreetingFormat")).withNoArguments().thenReturn("Good Morning %s %s");
		User user = getNewUser();
		assertEquals("Good Morning Code Geeks", spy.getGreetingText(user));
	}

	private User getNewUser() {
		User user = new User();
		user.setFirstName("Code");
		user.setSurname("Geeks");
		return user;
	}

}
