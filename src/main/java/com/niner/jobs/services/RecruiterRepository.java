package com.niner.jobs.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.niner.jobs.models.Recruiter;

public interface RecruiterRepository extends MongoRepository<Recruiter,  String>{

	
	public Recruiter findByName(String name);
}
