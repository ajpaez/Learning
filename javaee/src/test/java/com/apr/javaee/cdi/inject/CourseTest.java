package com.apr.javaee.cdi.inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;

import org.junit.Test;

import com.apr.javaee.TestBase;

public class CourseTest extends TestBase {

	@EJB
	private Course course;

	@Test
	public void test() {

		// Was the EJB injected?
		assertTrue(course != null);

		// Was the Course @PostConstruct called?
		assertNotNull(course.getCourseName());
		assertTrue(course.getCapacity() > 0);

		// Was a Faculty instance injected into Course?
		final Faculty faculty = course.getFaculty();
		assertTrue(faculty != null);

		// Was the @PostConstruct called on Faculty?
		assertEquals(faculty.getFacultyName(), "Computer Science");
		assertEquals(faculty.getFacultyMembers().size(), 2);
	}

}
