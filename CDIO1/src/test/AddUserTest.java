package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.UserDTO;
import funktion.DataManager;
import funktion.IUserDAO.DALException;

public class AddUserTest {
	DataManager DataManagerTest;
	UserDTO TestUser;

	@Before
	public void setUp() throws Exception 
	{
		this.TestUser = new UserDTO();
		this.DataManagerTest = new DataManager();
		
		
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
	
	@Test
	public void IdUnder10Test() throws DALException
	{
		this.TestUser.setUserId(5);
		Object actual = this.DataManagerTest.getUser(5);
		Object unexpected = this.TestUser;
		assertNotEquals(unexpected, actual);
	}

	@Test
	public void IdOver99Test() throws DALException
	{
		this.TestUser.setUserId(120);
		Object actual = this.DataManagerTest.getUser(120);
		Object unexpected = this.TestUser;
		assertNotEquals(unexpected, actual);
	}
	
	
	
	
	
	
	

}
