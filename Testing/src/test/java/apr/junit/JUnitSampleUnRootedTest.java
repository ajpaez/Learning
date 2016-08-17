package apr.junit;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;

//Esta anotacion lanza los test ordenados
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// Esta anotacion BlockJUnit4ClassRunner permite lanzar test de JUnit 3 en
// JUnit4
@RunWith(BlockJUnit4ClassRunner.class)
public class JUnitSampleUnRootedTest {

	int totalNumberOfApplicants = 0;
	int totalNumberOfAcceptableApplicants = 10;

	@Test
	public void testAssertions() {
		assertTrue((this.totalNumberOfApplicants != this.totalNumberOfAcceptableApplicants));
	}

	@Test
	public void testAssertTrueWithMessage() {
		assertTrue("Is total number of applicants acceptable?",
				(this.totalNumberOfApplicants != this.totalNumberOfAcceptableApplicants));
	}
}