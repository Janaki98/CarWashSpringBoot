package com.example.demo.service;

import java.util.List;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.entity.WasherDetails;
import com.mongodb.client.result.UpdateResult;

public interface WasherService {

	WasherDetails login(WasherDetails washer) throws CarWashException;

	List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException;

	CustCarDetails changeStatusService(CustCarDetails details) throws CarWashException;
}
