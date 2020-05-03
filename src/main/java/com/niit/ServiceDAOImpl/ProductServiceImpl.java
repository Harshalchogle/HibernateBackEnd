package com.niit.ServiceDAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.DAO.ProductDAO;
import com.niit.ServiceDAO.ProductServiceDAO;
import com.niit.model.Products;
@Service
public class ProductServiceImpl implements ProductServiceDAO
{
	@Autowired
	ProductDAO productDAO;

	@Override
	public boolean addProduct(Products products) {
		productDAO.addProduct(products);
		return true;
	}

	@Override
	public boolean updateProduct(Products products) {
		productDAO.updateProduct(products);
		return true;
	}

	@Override
	public boolean deleteProduct(int productid) {
		productDAO.deleteProduct(productid);
		return true;
	}

	@Override
	public List<Products> displayAllProducts() {
		return productDAO.displayAllProducts();
	}

	@Override
	public Products displayProductsById(int productid) {
		return productDAO.displayProductsById(productid);
	}
	

}
