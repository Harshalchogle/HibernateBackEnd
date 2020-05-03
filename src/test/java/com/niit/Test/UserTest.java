package com.niit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.ServiceDAO.UserServiceDAO;
import com.niit.config.AppConfig;
import com.niit.model.User;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class UserTest 
{
	User user=new User();
	@Autowired
	UserServiceDAO userDAO;
	@Test
	@Ignore
	public void addUser()
	{
		
		user.setUsername("Dipu");
		user.setPassword("12345");
		user.setEmail("dipu@gmail");
		assertEquals(true, userDAO.addUser(user));
	}
	@Test
	@Ignore
	public void updateUser()
	{
		user.setUserid(1);
		user.setUsername("Harshal");
		user.setPassword("12345");
		user.setEmail("dipu@gmail");
		assertEquals(true, userDAO.updateUser(user));
	}
	@Test
	@Ignore
	public void deleteUser()
	{
		
		assertEquals(true,userDAO.deleteUser(1));
	}
	@Test
	public void displayUsers()
	{
		assertNotNull(userDAO.displayUser());
	}
}
