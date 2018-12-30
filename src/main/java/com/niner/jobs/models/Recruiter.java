package com.niner.jobs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.niner.jobs.models.Company;

//@Entity
@Document(collection= "Recruiter")
public class Recruiter {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	
	private String name;
	private String email;
	private String contact;
	@DBRef
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Company company;
	
	public Recruiter() {
		// TODO Auto-generated constructor stub
	}

	public Recruiter(String name, String email, String contact, Company company) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.company = company;
	}
	

	public  String getId() {
		return id;
	}

	public void setId( String id) {
		this.id = id;
	}
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", company=" + company + "]";
	}
	
}





//package com.niner.jobs.models;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import com.niner.jobs.CascadeSave;
//
//@Document(collection = "recruiter")
//public class Recruiter {
//	@Id
//	private String id;
//	
//	private String name;
//	private String email;
//	private String contact;
//	private Company company;
//	private Recruiter() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Recruiter(String name, String email, String contact, Company company) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.contact = contact;
//		this.company = company;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getContact() {
//		return contact;
//	}
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//	public Company getCompany() {
//		return company;
//	}
//	public void setCompany(Company company) {
//		this.company = company;
//	}
//
//}
