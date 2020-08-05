package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.dao.WasherDao;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.entity.WasherDetails;
import com.mongodb.client.result.UpdateResult;
@Service
public class WasherServiceImpl implements WasherService{

	@Autowired
	private WasherDao washerDao;
	@Override
	public WasherDetails login(WasherDetails washer) throws CarWashException {
		WasherDetails result = washerDao.findUser(washer);
		if (result==null) {
			throw new CarWashException("error");
		}
		return result;
	}

	@Override
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException {
	List<CustCarDetails> viewDetails= washerDao.viewDetails(details);
		
		return viewDetails;
	}

	@Override
	public CustCarDetails changeStatusService(CustCarDetails details) throws CarWashException {
		
		CustCarDetails result = washerDao.changeStatusDao(details);
		return result;
	}

}
