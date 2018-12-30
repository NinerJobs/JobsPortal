//package com.niner.jobs.models;
//
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.niner.jobs.services.CompanyRepository;
//import com.niner.jobs.services.JobRepository;
//
//@Component
//public class UserCommandLineRunner implements CommandLineRunner {
//
//	private static final Logger log = LoggerFactory
//			.getLogger(UserCommandLineRunner.class);
//
//	@Autowired
//	private CompanyRepository repository;
//	
//	@Autowired
//	private JobRepository jobrepository;
//
//	public void run(String... arg0) throws Exception {
//		// TODO Auto-generated method stub
//		
//		repository.save(new Company("SAP", null, "138 Dexter Avenue San Fransisco, Claifornia","ERP Company",null));
//		
//		List<Company> companies = (List<Company>) repository.findAll();
//		for(Company c : companies) {
//				
//			jobrepository.save(new Job("Data Scientist", "Build ML Models",c, new Date(), new Date(), 1, null));
//		}
//	
//	}
//
//
//	}
