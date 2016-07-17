package apr.powermock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class UtilsTest {
	
	/**
	 * Test para hacer mock sobre metodos privados
	 */
	
	
	@Test
	public void testMockFinal() {
		Utils utils = PowerMock.createMock(Utils.class);
		EasyMock.expect(utils.saluda()).andReturn("Adios!!!");
		PowerMock.replay(utils);
		String actual = utils.saluda();
		PowerMock.verify(utils);
		Assert.assertEquals(actual, "Adios!!!");
	}

}
