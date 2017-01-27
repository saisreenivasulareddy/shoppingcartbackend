package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.CheckOut;

public interface CheckOutDAO {
	public boolean saveOrUpdate(CheckOut checkout);

	public boolean delete(CheckOut checkout);

	public List<CheckOut> list();

	public CheckOut get(int id);
}