package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.dao.AdminDao;
import com.example.demo.entity.AdminDetails;
import com.example.demo.entity.CustCarDetails;

@Service
public class AdminServiceImpl implements AdminService{

@Autowired
	
	private AdminDao adminDao;
	@Override
	public AdminDetails login(AdminDetails admin) throws CarWashException {
		AdminDetails result = adminDao.findUser(admin);
		if (result==null) {
			throw new CarWashException("error");
		}
		return result;

	}
	@Override
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException {
		List<CustCarDetails> viewDetails= adminDao.viewDetails(details);
		
		return viewDetails;
	}

}
