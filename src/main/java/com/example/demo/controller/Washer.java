package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.CarWashException;
import com.example.demo.entity.CustCarDetails;
import com.example.demo.entity.WasherDetails;
import com.example.demo.service.WasherService;

@RestController
@RequestMapping(value = "/washer")
@CrossOrigin(origins = "http://localhost:4200")
public class Washer {

	@Autowired
	private WasherService washerService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public WasherDetails checkUser(@RequestBody WasherDetails washer) throws CarWashException {

		System.out.println("iinnnnn");
		WasherDetails result;
		try {

//			System.out.println(washer.getUserName());
			result = washerService.login(washer);
			System.out.println(result.getName());
		} catch (Exception e) {
			throw new CarWashException("Error Occurred");
		}
		System.out.println("usfiug");
		return result;
	}

	@RequestMapping(value = "/view", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	public List<CustCarDetails> viewDetails(@RequestBody CustCarDetails details) throws CarWashException {
		System.out.println(details.getName());
		List<CustCarDetails> result = washerService.viewDetails(details);
//		System.out.println(result.)
//		System.out.println("qwerty");
		if (result == null) {
			throw new CarWashException("No Records found");
		}
		return result;
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	public CustCarDetails changeStatus(@RequestBody CustCarDetails details) throws CarWashException {
		
		System.out.println(details.get_id());
		CustCarDetails result = washerService.changeStatusService(details);
		if(result == null) {
			throw new CarWashException("ID doesn't Exists");
		}
		return result;
		
	}
	
}

