package com.niit.DAO;


import java.util.List;

import com.niit.model.Products;

public interface ProductDAO
{
	public boolean addProduct(Products products);
	public boolean updateProduct(Products products);
	public boolean deleteProduct(int productid);
	public List<Products> displayAllProducts();
	public Products displayProductsById(int productid);

}
