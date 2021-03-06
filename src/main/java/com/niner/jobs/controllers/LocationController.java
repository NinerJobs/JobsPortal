package com.niner.jobs.controllers;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.niner.jobs.models.Location;
import com.niner.jobs.services.LocationRepository;

@RestController
public class LocationController {
//	private static final Logger log = LoggerFactory
//            .getLogger(LocationController.class);


	@Autowired
	LocationRepository locationrepository;
	
	@GetMapping("/locations")
	public Iterable<Location> locations(){
		return locationrepository.findAll();
	}
	
	
	@PostMapping("/locations")
	public Location createJob(@RequestBody Location location){
	
		return locationrepository.insert(location);
		
	}
}	
