package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Product;

public interface ProductDAO {
	public List<Product> list();

	public Product get(int id);

	public boolean saveOrUpdate(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public List<Product> getproduct(int id);

	public List<Product> navproduct(int id);

}