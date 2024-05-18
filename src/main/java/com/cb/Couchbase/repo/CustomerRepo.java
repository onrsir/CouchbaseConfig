package com.cb.Couchbase.repo;

import com.cb.Couchbase.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer,Integer> {

}
