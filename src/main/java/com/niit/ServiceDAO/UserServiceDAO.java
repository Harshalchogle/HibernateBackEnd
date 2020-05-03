package com.niit.ServiceDAO;

import java.util.List;

import com.niit.model.User;

public interface UserServiceDAO 
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userid);
	public User displayUserById(int userid);
	public List<User> displayUser();
	public User displayUserByUsername(String username);
}