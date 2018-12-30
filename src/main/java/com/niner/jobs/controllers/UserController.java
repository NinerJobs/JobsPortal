package com.niner.jobs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niner.jobs.models.Company;
import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;
import com.niner.jobs.models.User;
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;
import com.niner.jobs.services.RecruiterRepository;
import com.niner.jobs.services.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger log = LoggerFactory
            .getLogger(UserController.class);

	@Autowired
	RecruiterRepository recruiterrepository;

	@Autowired
	JobRepository jobrepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@Autowired
	UserRepository userrepository;
	
	@GetMapping("")
	public Iterable<User> users(){
		return userrepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable String id){
		return userrepository.findById(id).orElse(null);
	}
	
	@PostMapping("")
	public User createUser(@RequestBody User user){
		user.setAppliedjobs(new ArrayList<Job>());
		Company company = companyrepository.findByName(user.getCurrentcompany());
		if(company==null) {
			Company c = new Company();
			c.setName(user.getCurrentcompany());
			c.setRecruiter(new ArrayList<Recruiter>());
			companyrepository.save(c);
			user.setCompany(c);
			return userrepository.save(user);	
		}
		else {
			user.setCompany(company);
			return userrepository.save(user);
		}	
	}
	
//	@PostMapping("/{recruiterid}/jobs")
//	public Job createJob(@RequestBody Job job, @PathVariable  String recruiterid){
//	 Recruiter recruiter= getRecruiter(recruiterid);
//	 job.setRecruiter(recruiter);
//	 Job createdJob =  jobrepository.insert(job);
//	 return createdJob;
//	}
//	
//	//Get Jobs posted by a recruiter
//	@GetMapping("/{recruiterid}/jobs")
//	public List<Job> GetJobsByRecruiter(@PathVariable  String recruiterid){
//	 Recruiter recruiter= getRecruiter(recruiterid);
//	 List<Job> jobs = jobrepository.findByRecruiter(recruiter);
//	 return jobs;
//	}
//	
//	@DeleteMapping("/{recruiterid}/jobs/{jobId}")
//	public List<Job> deleteJob(@PathVariable  String recruiterid, @PathVariable  String jobId){
//	 Boolean jobFound = ifJobPostedByRecruiter(recruiterid, jobId);
//	 
//	 if(jobFound) {
//		 jobrepository.deleteById(jobId);
//	 }
//	 
//	 return GetJobsByRecruiter(recruiterid);
//	}
//	
//	
//	@PutMapping("/{recruiterid}/jobs/{jobId}")
//	public Job updateJob(@RequestBody Job newJob,@PathVariable  String recruiterid, @PathVariable  String jobId){
//	 Boolean jobFound = ifJobPostedByRecruiter(recruiterid, jobId);
//	 
//	 if(jobFound) {
//		 
//		 jobrepository.findById(jobId).map(job -> {
//				job.setTitle(newJob.getTitle());
//				job.setDescription(newJob.getDescription());
//				job.setVacancies(newJob.getVacancies());
//				job.setClosingDate(newJob.getClosingDate());
//				job.setLocations(newJob.getLocations());
//				return jobrepository.save(job);
//			});
////			.orElseGet(() -> {
////				newJob.setId(jobId);
////				return jobrepository.save(newJob);
////			});
//	 }
//	 
//	 return null;
//	}
//
//	private Boolean ifJobPostedByRecruiter(String recruiterid, String jobId) {
//		 List<Job> jobs = GetJobsByRecruiter(recruiterid);
//		 Boolean jobFound = false;
//		 
//		 for(Job j : jobs){
//			 if(j.getId().equals(jobId)) {
//				 jobFound = true;
//				 break;
//			 }
//		 }
//		return jobFound;
//	}
}



