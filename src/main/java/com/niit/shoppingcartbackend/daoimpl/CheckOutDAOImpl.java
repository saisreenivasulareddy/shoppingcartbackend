package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.CheckOutDAO;
import com.niit.shoppingcartbackend.model.CheckOut;



public class CheckOutDAOImpl implements CheckOutDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public CheckOutDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(CheckOut checkout) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean delete(CheckOut checkout) {
			try {
				sessionFactory.getCurrentSession().delete(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<CheckOut> list() {
		String hql ="from Checkout";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public CheckOut get(int id) {
		String hql = "from Checkout where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<CheckOut>list= query.list();
		
		if(list.isEmpty())
		{
			
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
}