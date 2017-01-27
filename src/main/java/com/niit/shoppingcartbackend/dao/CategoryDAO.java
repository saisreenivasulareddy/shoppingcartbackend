package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Category;

public interface CategoryDAO {
	public List<Category> list();

	public Category get(int id);

	public boolean saveorupdate(Category category);

	//public boolean update(Category category);

	public boolean delete(Category category);
}