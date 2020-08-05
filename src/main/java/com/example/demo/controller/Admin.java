package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.AdminDetails;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/admin")
public class Admin {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AdminDetails checkUser(@RequestBody AdminDetails admin) throws CarWashException {
//		String uName = admin.getUserName();
		System.out.println("iinnnnn");
		AdminDetails result;
		try {
			
			result=adminService.login(admin);
		} catch (Exception e) {
			throw new CarWashException("Error Occurred");
			
		}
		return result;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public List<CustCarDetails> viewDetails(@RequestBody CustCarDetails details)throws CarWashException{
		
		List<CustCarDetails> result=adminService.viewDetails(details);
//		System.out.println("qwerty");
			if(result==null) {
				throw new CarWashException("No Records found");
			}
		return result;
	}
}
