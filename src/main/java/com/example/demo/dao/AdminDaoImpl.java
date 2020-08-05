package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.AdminDetails;
import com.example.demo.entity.CustCarDetails;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private MongoTemplate mongoTemplate;
//	@Autowired
//	private MongoOperations mongoOperation;
	

	@Override
	public AdminDetails findUser(AdminDetails admin) throws CarWashException {
			Query query = new Query();
			Query query1 = new Query();
			String uName = admin.getUserName();
			String pwd = admin.getPassword();
			try {
			System.out.println(uName);
			System.out.println(pwd);
				
				query = query.addCriteria(Criteria.where("userName").is(uName).andOperator(Criteria.where("password").is(pwd)));
				query1=query1.addCriteria(Criteria.where("userName").is(uName));
				boolean dataExists = mongoTemplate.exists(query, "adminDetails");
				if (dataExists) {
					System.out.println("gyguygy123");
					return mongoTemplate.findOne(query1, AdminDetails.class);
				}
			} 
			catch (Exception e) {
				throw new CarWashException("reposit error");
			}
			return null;
	}


	@Override
	public List<CustCarDetails> viewDetails( CustCarDetails details) throws CarWashException {
		Query query = new Query();
	
		String washerName = details.getName();
		try{
			
				query=query.addCriteria(Criteria.where("name").is(washerName));
				boolean dataExists = mongoTemplate.exists(query, "custCarDetails");
				if(dataExists) {
					return mongoTemplate.find(query, CustCarDetails.class);
				}
				else {
					List<CustCarDetails> list=mongoTemplate.findAll(CustCarDetails.class);
					return list;
				}
	} catch (Exception e) {
		throw new CarWashException("reposit error");
	}
	}	
		
	}


