package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ProductDAO;
import com.niit.model.Products;
@Repository(value = "productDAO")
@Transactional
public class ProductImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addProduct(Products products) {
		sessionfactory.getCurrentSession().save(products);
		return true;
	}

	@Override
	public boolean updateProduct(Products products) {
		sessionfactory.getCurrentSession().update(products);
		return true;
	}

	@Override
	public boolean deleteProduct(int productid) {
		Products pr=new Products();
		pr.setProductid(productid);
		sessionfactory.getCurrentSession().delete(pr);
		return true;
	}

	@Override
	public List<Products> displayAllProducts() {
		return sessionfactory.getCurrentSession().createQuery("from com.niit.model.Products").getResultList();
	}

	@Override
	public Products displayProductsById(int productid) {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Products where productid=:productid");
		return (Products) query.setParameter("productid",productid).getResultList().get(0);
	}
}
