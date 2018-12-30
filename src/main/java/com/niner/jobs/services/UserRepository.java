package com.niner.jobs.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.niner.jobs.models.User;

public interface UserRepository extends MongoRepository<User,String>{

}
