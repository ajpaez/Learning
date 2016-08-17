package apr.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class ListHandlerTest {

	private ListHandler listHandlerMock;

	@Before
	public void setUp() {
		listHandlerMock = Mockito.mock(ListHandler.class);
	}

	@Test
	public void testAdd() {
		boolean actual = false;

		// Si estamos usando un matcher en el stub de un método, cada parámetro
		// tiene que ser expresada con un matcher.
		Mockito.when(this.listHandlerMock.add(Matchers.anyList(), Matchers.any())).thenReturn(true);

		// Illegal; a Matcher has to be used.
		// Mockito.when(this.listHandlerMock.add(Matchers.anyList(), "A
		// value")).thenReturn(true);

		actual = this.listHandlerMock.add(Matchers.anyList(), Matchers.any());
		Assert.assertTrue(actual);

		Mockito.verify(this.listHandlerMock).add(Matchers.anyList(), Matchers.any());
	}

	@Test
	public void testRemove() {
		Object actual = null;

		Object o = new Object();
		Mockito.when(this.listHandlerMock.remove(Matchers.anyList(), Matchers.anyInt())).thenReturn(o);

		actual = this.listHandlerMock.remove(Matchers.anyList(), Matchers.anyInt());
		Assert.assertTrue(actual.equals(o));

		Mockito.verify(this.listHandlerMock).remove(Matchers.anyList(), Matchers.anyInt());
	}

}
