package com.cb.Couchbase.repo;

import com.cb.Couchbase.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CouchbaseRepository<User, UUID> {
}
