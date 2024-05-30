package org.univamu.polytech.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.univamu.polytech.backend.data.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
