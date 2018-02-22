package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.UserDTO;
import funktion.DataManager;
import funktion.IUserDAO.DALException;
import funktion.TUI;

public class AddUserTest {
	DataManager DataManagerTest;
	UserDTO TestUser;
	TUI TestTUI;

	@Before
	public void setUp() throws Exception 
	{
		this.TestUser = new UserDTO();
		this.DataManagerTest = new DataManager();
		this.TestTUI = new TUI();
		
		this.DataManagerTest.createUser(this.TestUser);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void positiveTest() throws DALException 
	{
		this.TestUser.setUserId(50);
		Object actual = this.DataManagerTest.getUser(50);
		Object expected = this.TestUser;
		assertEquals(expected, actual);
	}
	
	@Test
	public void negativeTest() throws DALException
	{
		this.TestUser.setUserId(50);
		Object actual = this.DataManagerTest.getUser(51);
		Object unexpected = this.TestUser;
		assertNotEquals(unexpected, actual);
	}
	
	
	
	
	
	
	

}
