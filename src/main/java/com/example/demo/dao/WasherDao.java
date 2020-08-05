package com.example.demo.dao;

import java.util.List;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.entity.WasherDetails;
import com.mongodb.client.result.UpdateResult;

public interface WasherDao {

	public WasherDetails findUser(WasherDetails washer) throws CarWashException;

	List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException;

	public CustCarDetails changeStatusDao(CustCarDetails details) throws CarWashException;
}
