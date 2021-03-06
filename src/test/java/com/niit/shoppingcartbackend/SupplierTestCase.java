package com.niit.shoppingcartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SupplierTestCase {
	@Autowired
	 static SupplierDAO supplierDAO;
	@Autowired
	 static Supplier supplier;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		
		supplier=(Supplier)context.getBean("supplier");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAOImpl");
		
	}
	
	
@Test
	public void saveTestCase()
	{
		supplier.setName("Mukesh");
		supplier.setAddress("hyd");
		
	Assert.assertEquals("save Test Case",true,supplierDAO.saveOrUpdate(supplier));
	}

	
		

	}

