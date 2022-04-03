package com.testapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.testapi.CustomException.BusinessException;
import com.testapi.CustomException.ControllerException;
import com.testapi.Entity.api;
import com.testapi.Service.apiService;

@RestController
public class restController {
	
	@Autowired
	private apiService service;
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") long id){
		try {
			api getusingid = service.getusingid(id);
			return new ResponseEntity<api>(getusingid,HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException cexe= new ControllerException(e.getErrorcode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(cexe,HttpStatus.NOT_FOUND);
			
		} 
	}

}
