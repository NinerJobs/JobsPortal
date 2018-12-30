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
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;
import com.niner.jobs.services.RecruiterRepository;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {
	
	private static final Logger log = LoggerFactory
            .getLogger(RecruiterController.class);

	@Autowired
	RecruiterRepository recruiterrepository;

	@Autowired
	JobRepository jobrepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@GetMapping("")
	public Iterable<Recruiter> recruiters(){
		return recruiterrepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Recruiter getRecruiter(@PathVariable String id){
		return recruiterrepository.findById(id).orElse(null);
	}
	
	@GetMapping("/name={name}")
	public Recruiter findByRecruitername(@PathVariable String name){
		return recruiterrepository.findByName(name);
	}
	
	
	@PostMapping("")
	public Recruiter createRecruiter(@RequestBody Recruiter recruiter, @RequestParam String name){
		Company company = companyrepository.findByName(name);
		recruiter.setCompany(company);
		//log.info(recruiter.toString());
		Recruiter newRecruiter= recruiterrepository.insert(recruiter);
		 List<Recruiter> recruiters = company.getRecruiter();
		 recruiters.add(newRecruiter);
		 company.setRecruiter(recruiters);
		companyrepository.save(company);	
		return newRecruiter;
		
	}
	
	@PostMapping("/{recruiterid}/jobs")
	public Job createJob(@RequestBody Job job, @PathVariable  String recruiterid){
	 Recruiter recruiter= getRecruiter(recruiterid);
	 job.setRecruiter(recruiter);
	 Job createdJob =  jobrepository.insert(job);
//	 Company company = companyrepository.findByRecruiter(recruiter);
////	 List<Job>jobs = company.getJobs();
////	 jobs.add(job);
////	 company.setJobs(jobs);
//	 companyrepository.save(company);
	 return createdJob;
	}
	
	//Get Jobs posted by a recruiter
	@GetMapping("/{recruiterid}/jobs")
	public List<Job> GetJobsByRecruiter(@PathVariable  String recruiterid){
	 Recruiter recruiter= getRecruiter(recruiterid);
	 List<Job> jobs = jobrepository.findByRecruiter(recruiter);
	 return jobs;
	}
	
	@DeleteMapping("/{recruiterid}/jobs/{jobId}")
	public List<Job> deleteJob(@PathVariable  String recruiterid, @PathVariable  String jobId){
	 Boolean jobFound = ifJobPostedByRecruiter(recruiterid, jobId);
	 
	 if(jobFound) {
		 jobrepository.deleteById(jobId);
	 }
	 
	 return GetJobsByRecruiter(recruiterid);
	}
	
	
	@PutMapping("/{recruiterid}/jobs/{jobId}")
	public Job updateJob(@RequestBody Job newJob,@PathVariable  String recruiterid, @PathVariable  String jobId){
	 Boolean jobFound = ifJobPostedByRecruiter(recruiterid, jobId);
	 
	 if(jobFound) {
		 
		 jobrepository.findById(jobId).map(job -> {
				job.setTitle(newJob.getTitle());
				job.setDescription(newJob.getDescription());
				job.setVacancies(newJob.getVacancies());
				job.setClosingDate(newJob.getClosingDate());
				job.setLocations(newJob.getLocations());
				return jobrepository.save(job);
			});
//			.orElseGet(() -> {
//				newJob.setId(jobId);
//				return jobrepository.save(newJob);
//			});
	 }
	 
	 return null;
	}

	private Boolean ifJobPostedByRecruiter(String recruiterid, String jobId) {
		 List<Job> jobs = GetJobsByRecruiter(recruiterid);
		 Boolean jobFound = false;
		 
		 for(Job j : jobs){
			 if(j.getId().equals(jobId)) {
				 jobFound = true;
				 break;
			 }
		 }
		return jobFound;
	}
}





//package com.niner.jobs.controllers;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.niner.jobs.models.Company;
//import com.niner.jobs.models.Job;
//import com.niner.jobs.models.Recruiter;
//import com.niner.jobs.services.CompanyRepository;
//import com.niner.jobs.services.JobRepository;
//import com.niner.jobs.services.RecruiterRepository;
//
//
//
//@RestController
//public class RecruiterController{
//	
//	@Autowired
//	CompanyRepository companyrepository;
//	
//	@Autowired
//	RecruiterRepository recruiterepository;
//	
//	@Autowired
//	JobRepository jobrepository;
//
//	@GetMapping("/recruiters")
//	public Iterable<Recruiter> getRecruiters() {
//		return recruiterepository.findAll();
//	}
//	
//	@GetMapping("/recruiters/{id}")
//	public Recruiter getRecruiterById(@PathVariable  String recruiterid) {
//		return recruiterepository.findById(recruiterid).orElse(null);
//	}
//	@PostMapping("/recruiters")
//	public Recruiter createRecruiter(@RequestBody Recruiter recruiter, @RequestParam String name) {
//		Company company = companyrepository.findByName(name);
//		recruiter.setCompany(company);
//		Recruiter createdRecruiter= recruiterepository.save(recruiter);
////		company.setRecruiter(createdRecruiter);
////		companyrepository.save(company);
//		return createdRecruiter;
//	}
//	
//	@PostMapping("/recruiters/{recruiterid}/jobs")
//	public Job createJob(@RequestBody Job job, @PathVariable  String recruiterid){
//	 Recruiter recruiter= getRecruiterById(recruiterid);
//	 job.setRecruiter(recruiter);
//	 Job createdJob =  jobrepository.save(job);
//	 Company company = recruiter.getCompany();
//	 List<Job>jobs = company.getJobs();
//	 jobs.add(job);
//	 company.setJobs(jobs);
//	 companyrepository.save(company);
//	 return createdJob;
//	}
//
//}