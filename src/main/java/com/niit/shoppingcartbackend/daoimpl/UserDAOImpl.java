package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

@SuppressWarnings("deprecation")
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> list() {
		String hql ="from user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.list();
		return null;
	}
    @Transactional
	public User get(String id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
    @Transactional
	public User validate(String id, String password) {
		String hql="from user where id='"+id+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();
	}

	public boolean save(User user) {
		try{
		  sessionFactory.getCurrentSession().save(user);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	public boolean update(User User) {
		try {
			sessionFactory.getCurrentSession().update(User);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	@Override
	public boolean saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validate(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
