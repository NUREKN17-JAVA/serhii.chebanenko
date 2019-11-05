package ua.nure.cs.chebanenko.usermanagement171.domain;

import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;

public class UserTest extends TestCase {

	private static final int ETALONE_AGE = 22;
	private static final int DAY_OF_BIRTH = 11;
	private static final int MONTH_OF_BIRTH = 9;
	private static final int YEAR_OF_BIRTH = 1997;

	private static final int DAY_OF_BIRTH_2 = 16;
	private static final int MONTH_OF_BIRTH_2 = 10;

	private static final int ETALONE_AGE_3 = 21;
	private static final int DAY_OF_BIRTH_3 = 5;
	private static final int MONTH_OF_BIRTH_3 = 11;

	private static final int DAY_OF_BIRTH_4 = 2;
	private static final int MONTH_OF_BIRTH_4 = 7;

	private static final int DAY_OF_BIRTH_5 = 2;
	private static final int MONTH_OF_BIRTH_5 = 7;
	private static final int YEAR_OF_BIRTH_5 = 2004;

	private static final int YEAR_OF_BIRTH_6 = 1900;

	private User user;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	// Test to get user full name
	public void testGetFullName() {
		user.setFirstName("Serhii");
		user.setLastName("Chebanenko");
		assertEquals("Chebanenko, Serhii", user.getFullName());
	}

	// Test to get age
	public void testGetAge1() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETALONE_AGE, user.getAge());
	}

	// Test to get age if on this day
	public void testGetAge2() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_2, DAY_OF_BIRTH_2);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETALONE_AGE, user.getAge());

	}

	// Test to get age if future
	public void testGetAge3() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_3, DAY_OF_BIRTH_3);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETALONE_AGE_3, user.getAge());
	}

	// Test to get age if past
	public void testGetAge4() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_4, DAY_OF_BIRTH_4);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETALONE_AGE, user.getAge());
	}

	// age limit test
	public void testAge5() {
		Calendar calendarUser = Calendar.getInstance();
		Calendar calendarCurrent = Calendar.getInstance();
		calendarUser.set(YEAR_OF_BIRTH_5, MONTH_OF_BIRTH_5, DAY_OF_BIRTH_5);
		user.setDateOfBirth(calendarUser.getTime());
		calendarUser.setTime(user.getDateOfBirth());
		calendarCurrent.setTime(new Date());
		assertTrue(calendarUser.get(Calendar.YEAR) <= calendarCurrent.get(Calendar.YEAR) - 14);
	}

	// age limit test
	public void testAge6() {
		Calendar calendarUser = Calendar.getInstance();
		Calendar calendarCurrent = Calendar.getInstance();
		calendarUser.set(YEAR_OF_BIRTH_6, MONTH_OF_BIRTH_5, DAY_OF_BIRTH_5);
		user.setDateOfBirth(calendarUser.getTime());
		calendarUser.setTime(user.getDateOfBirth());
		calendarCurrent.setTime(new Date());
		assertTrue(calendarCurrent.get(Calendar.YEAR) - calendarUser.get(Calendar.YEAR) <= 120);
	}
}