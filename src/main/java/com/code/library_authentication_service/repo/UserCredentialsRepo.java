package com.code.library_authentication_service.repo;

import com.code.library_authentication_service.entity.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepo extends MongoRepository<UserCredentials,String> {
    Optional<UserCredentials> findByUsername(String username);
}
