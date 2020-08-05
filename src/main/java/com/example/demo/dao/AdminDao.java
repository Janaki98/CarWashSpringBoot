package com.example.demo.dao;

import java.util.List;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.AdminDetails;
import com.example.demo.entity.CustCarDetails;


public interface AdminDao {

	public AdminDetails findUser(AdminDetails admin) throws CarWashException;

	public List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException;
}
