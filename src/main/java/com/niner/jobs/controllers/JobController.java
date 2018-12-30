package com.niner.jobs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niner.jobs.models.Job;
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {
//	private static final Logger log = LoggerFactory
//            .getLogger(JobController.class);


	@Autowired
	JobRepository jobrepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
//	@GetMapping("")
//	public Iterable<Job> jobs(){
//		return jobrepository.findAll();
//	}
	
	//Get All Jobs, Jobs based on title and company
	@GetMapping("")
	public List<Job> jobs(@RequestParam(value = "title", required = false) String name, @RequestParam(value ="company", required = false) String company_name){
		
		if(name==null && company_name==null) {
			return jobrepository.findAll();
		}
		
		else if(company_name==null&&name!=null) {
			List<Job> jobs = new ArrayList<Job>();
			for(Job j : jobrepository.findAll()){
				if(name.equals(j.getTitle())) {
					jobs.add(j);
				}
			}
			return jobs;
		}
		
		else if(company_name!=null&&name==null) {
			List<Job> jobs = new ArrayList<Job>();
			for(Job j : jobrepository.findAll()){
			if(company_name.equals(j.getRecruiter().getCompany().getName())){
					jobs.add(j);
				}
			}

			return jobs;
		}
		else if(company_name!=null&&name!=null) {
			List<Job> jobs = new ArrayList<Job>();
			for(Job j : jobrepository.findAll()){
				if(company_name.equals(j.getRecruiter().getCompany().getName())){
					if(name.equals(j.getTitle())) {
						jobs.add(j);
					}
				}
			}

			return jobs;
		}
		
		return null;
	}
	
	@GetMapping("/{id}")
	public Optional<Job> findJobById(@PathVariable String id){
		return jobrepository.findById(id);
	}
	
//	@GetMapping("/name={name}")
//	public List<Job> findJobByCompany(@PathVariable String name){
//		List<Job> jobs = new ArrayList<Job>();
//		for(Job j : jobrepository.findAll()){
//			if(name.equals(j.getRecruiter().getCompany().getName())){
//				jobs.add(j);
//			}
//		}
//		return jobs;
//	}	
	
}	





//package com.niner.jobs.controllers;
//import java.net.URI;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.niner.jobs.models.Job;
//import com.niner.jobs.services.JobRepository;
//
//
//
//@RestController
//public class JobController{
//	
//	@Autowired
//	JobRepository jobrepository;
//	
//	//Get all questions for a given survey
//	@GetMapping("/jobs")
//	public Iterable<Job> getJobs() {
//		return jobrepository.findAll();
//	}
//	
//	//Get all questions for a given survey
//	@PostMapping("/jobs")
//	public Job createJob(@RequestBody Job job) {
//		  jobrepository.save(job);
//		  return job;
//		}
//}