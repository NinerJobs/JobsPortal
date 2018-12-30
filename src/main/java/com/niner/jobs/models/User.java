package com.niner.jobs.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.niner.jobs.models.Company;

//@Entity
@Document(collection= "User")
public class User {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String contact;
	private String summary;
	private String currentcompany;
	
	@DBRef
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Company company;
	
	@DBRef
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Job> appliedjobs;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String id, String firstname, String lastname, String email, String contact, String summary,
			String currentcompany, Company company, List<Job> appliedjobs) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contact = contact;
		this.summary = summary;
		this.currentcompany = currentcompany;
		this.company = company;
		this.appliedjobs = appliedjobs;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Job> getAppliedjobs() {
		return appliedjobs;
	}

	public void setAppliedjobs(List<Job> appliedjobs) {
		this.appliedjobs = appliedjobs;
	}



	public String getCurrentcompany() {
		return currentcompany;
	}



	public void setCurrentcompany(String currentcompany) {
		this.currentcompany = currentcompany;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", contact=" + contact + ", summary=" + summary + ", currentcompany=" + currentcompany + ", company="
				+ company + ", appliedjobs=" + appliedjobs + "]";
	}
	
	
	
}





