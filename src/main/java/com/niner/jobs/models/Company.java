package com.niner.jobs.models;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Entity
@Document(collection= "Company")
public class Company {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private  String id;
	private String name;
	//@OneToOne
	@DBRef
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Recruiter> recruiter;
	private String address;
	//@OneToMany
	//@DBRef
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	//private List<Job> jobs;
	private String description;
	
	public Company(){
	}

	public Company(String name, List<Recruiter> recruiter, String address,
			 String description) {
		super();
		this.name = name;
		this.recruiter = recruiter;
		this.address = address;
		//this.jobs = jobs;
		this.description = description;
	}

	public  String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Recruiter> getRecruiter() {
		return recruiter;
	}

	public String getAddress() {
		return address;
	}

//	public List<Job> getJobs() {
//		return jobs;
//	}

	public String getDescription() {
		return description;
	}

	public void setId( String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRecruiter(List<Recruiter> recruiter) {
		this.recruiter = recruiter;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public void setJobs(List<Job> jobs) {
//		this.jobs = jobs;
//	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", name=" + name + ", recruiter="
//				+ recruiter + ", address=" + address + ", jobs=" + jobs
//				+ ", description=" + description + "]";
//	}
	
	
	
	
}



//package com.niner.jobs.models;
//import java.util.List;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import com.niner.jobs.CascadeSave;
//
//@Document(collection = "company")
//public class Company {
//	@Id
//	private String id;
//	
//	private String name;
////	@DBRef
////	private Recruiter recruiter;
//	private String address;
//	private String description;
//	private List<Job> jobs;
//	
//	private Company() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Company(String name, String address, String description, List<Job> jobs) {
//		super();
//		this.name = name;
////		this.recruiter = recruiter;
//		this.address = address;
//		this.description = description;
//		this.jobs = jobs;
//	}
//	
////	public Company(String name, Recruiter recruiter, String address, String description, List<Job> jobs) {
////		super();
////		this.name = name;
////		this.recruiter = recruiter;
////		this.address = address;
////		this.description = description;
////		this.jobs = jobs;
////	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
////	public Recruiter getRecruiter() {
////		return recruiter;
////	}
////
////	public void setRecruiter(Recruiter recruiter) {
////		this.recruiter = recruiter;
////	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public List<Job> getJobs() {
//		return jobs;
//	}
//
//	public void setJobs(List<Job> jobs) {
//		this.jobs = jobs;
//	}
//
////	@Override
////	public String toString() {
////		return "Company [id=" + id + ", name=" + name + ", recruiter=" + recruiter + ", address=" + address
////				+ ", description=" + description + ", jobs=" + jobs + "]";
////	}
//	
//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", name=" + name + ", address=" + address
//				+ ", description=" + description + ", jobs=" + jobs + "]";
//	}
//	
//}
