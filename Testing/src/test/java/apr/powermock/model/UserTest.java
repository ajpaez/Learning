package apr.powermock.model;

import java.util.Date;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import apr.powermock.domain.User;

@RunWith(PowerMockRunner.class)
@PrepareForTest({User.class})
public class UserTest {

	/**
	 * Test para hacer mock sobre new
	 */

	@Mock
	private Date myDateMock;
	private User myUser;

	@Test
	public void testMockConstructor() throws Exception {
		
		myDateMock = PowerMock.createMock(Date.class);
		
		PowerMock.expectNew(Date.class).andReturn(myDateMock);
		EasyMock.expect(myDateMock.getTime()).andReturn(Long.MAX_VALUE);
		
		PowerMock.replay(Date.class, myDateMock);
		
		myUser = new User();
		
		long dateUser = myUser.getToday().getTime();
		
		Assert.assertTrue(dateUser == Long.MAX_VALUE);
	}

}
