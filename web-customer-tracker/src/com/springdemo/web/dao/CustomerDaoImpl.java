package com.springdemo.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.web.entity.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCastomers() {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// get result
		List<Customer> customers = theQuery.getResultList();
		
		// return result list
		return customers;
	}

}
