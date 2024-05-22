package com.cb.Couchbase.repo;

import com.cb.Couchbase.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer,Integer> {

    List<Customer> findByNameLike(String name);
    Optional<Customer> findByName(String name);

}
