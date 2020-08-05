package com.example.demo.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.entity.WasherDetails;
import com.mongodb.client.result.UpdateResult;
@Repository
public class WasherDaoImpl implements WasherDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
//	@Autowired
//	private MongoOperation mongoOperation;
	
	@Override
	public WasherDetails findUser(WasherDetails washer) throws CarWashException {
		Query query = new Query();
		Query query1 = new Query();
		String email = washer.getEmail();
		String pwd = washer.getPassword();
		try {
		System.out.println(email);
		System.out.println(pwd);
			
			query = query.addCriteria(Criteria.where("email").is(email).andOperator(Criteria.where("password").is(pwd)));
			query1=query1.addCriteria(Criteria.where("email").is(email));
			System.out.println(email);
			boolean dataExists = mongoTemplate.exists(query, "washerDetails");
			System.out.println(dataExists);
			if (dataExists) {
				System.out.println("gyguygy");
				return mongoTemplate.findOne(query1, WasherDetails.class);
			}
		} 
		catch (Exception e) {
			throw new CarWashException("reposit error");
		}
		return null;
	}

	@Override
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException {
		Query query = new Query();
		String washerName = details.getName();
		System.out.println(details.getName());
		try {
		query=query.addCriteria(Criteria.where("name").is(washerName));
			return mongoTemplate.find(query, CustCarDetails.class);
//		}
	} 
	catch(Exception e) {
		throw new CarWashException("reposit error");
	}
//	return null;
		
	}

	@Override
	public CustCarDetails changeStatusDao(CustCarDetails details) throws CarWashException {
		Query query = new Query();
		Update update = new Update();
		String id= details.get_id();
		String changeStatus = details.getStatus();
		System.out.println("daooo");
		System.out.println(id);
		try {
			query.addCriteria(Criteria.where("_id").is(id));
			boolean result=mongoTemplate.exists(query,CustCarDetails.class);

//			query=query.addCriteria(Criteria.where("_id").is(id));
//			boolean dataExists = mongoTemplate.exists(query, "custCarDetails");
			System.out.println(result);
			if(result) {
				System.out.println("changeStatus");

				System.out.println(changeStatus);
				update.set("status",changeStatus );
				mongoTemplate.updateFirst(query, update, CustCarDetails.class);
				return details;
			}
		}catch(Exception e) {
			throw new CarWashException("reposit error");
		}
		
		return null;
	}

}
