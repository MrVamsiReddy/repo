package com.testapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testapi.CustomException.BusinessException;
import com.testapi.Entity.api;
import com.testapi.Repository.Repository;

@Service
public class apiServiceImpl implements apiService {
	
	@Autowired
	private Repository repo;

	@Override
	public api getusingid(long id) {
		
		try {
			return repo.findById(id).get();
			
		}  catch(java.util.NoSuchElementException e) {
			throw new BusinessException("Status 0","data not found");
		}
		
	}

}
