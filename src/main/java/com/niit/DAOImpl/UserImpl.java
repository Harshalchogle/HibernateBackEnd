package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Repository(value = "userDAO")
@Transactional
public class UserImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) 
	{
		sessionFactory.getCurrentSession().save(user);
			return true;
	}

	@Override
	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	@Override
	public boolean deleteUser(int userid) {
		User user=new User();
		user.setUserid(userid);
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public List<User> displayUser() 
	{
		return sessionFactory.getCurrentSession().createQuery("from com.niit.Model.User").getResultList();
	}

	@Override
	public User displayUserById(int userid) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.Model.User where userid=:uid");
		return (User) query.setParameter("uid", userid).getResultList().get(0);
	}

	@Override
	public User displayUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.User where username=:uname");
		return (User) query.setParameter("uname",username).getResultList().get(0);
	}
	

}
