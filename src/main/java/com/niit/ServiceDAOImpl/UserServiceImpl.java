package com.niit.ServiceDAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.niit.DAO.UserDAO;
import com.niit.ServiceDAO.UserServiceDAO;
import com.niit.model.User;

@Service
public class UserServiceImpl implements UserServiceDAO{
	
	@Autowired
	UserDAO userDAO;
	public boolean addUser(User user) 
	{
		user.setAuthority("user");
		user.setStatus(false);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDAO.addUser(user);
		return true;
	
	}

	@Override
	public boolean updateUser(User user) {
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(int userid) {
	userDAO.deleteUser(userid);
		return true;
	}

	@Override
	public User displayUserById(int userid) {
	return userDAO.displayUserById(userid);
	
	}

	@Override
	public List<User> displayUser() {
		return	userDAO.displayUser();
		 
	}

	@Override
	public User displayUserByUsername(String username) {
		return userDAO.displayUserByUsername(username);
	}

}
