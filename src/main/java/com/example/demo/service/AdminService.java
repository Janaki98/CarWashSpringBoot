package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.AdminDetails;
import com.example.demo.entity.CustCarDetails;
@Service
public interface AdminService {
	AdminDetails login(AdminDetails admin) throws CarWashException;

	List<CustCarDetails> viewDetails(CustCarDetails details) throws CarWashException;

}