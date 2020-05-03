package com.niit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.ServiceDAO.ProductServiceDAO;
import com.niit.config.AppConfig;
import com.niit.model.Products;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class ProductTest 
{
	Products products=new Products();
	@Autowired
	ProductServiceDAO productDAO;
	
	@Test
	@Ignore
	public void addProduct()
	{
		products.setProductname("Samosa");
		products.setPrice(10);
		products.setQuantity(10);
		assertEquals(true, productDAO.addProduct(products));
	}

}
