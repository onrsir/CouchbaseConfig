package com.cb.Couchbase.repo;

import com.cb.Couchbase.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends CouchbaseRepository<User, UUID> {
    List<User> findByNameLike(String name);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndName(String email, String name);
    Optional<User> findByEmailOrName(String email, String name);
    List<User> findByEmailLike(String email);
    List<User> findByEmailStartingWith(String email);
    List<User> findByEmailEndingWith(String email);
    List<User> findByEmailContaining(String email);
    Optional<User> findByNameIgnoreCase(String name);
    List<User> findByEmailOrderByEmailAsc(String email);
    List<User> findByEmailOrderByEmailDesc(String email);
    Optional<User> findTopByOrderByEmailDesc();
    Optional<User> findTopByOrderByEmailAsc();
    Optional<User> findFirstByOrderByEmailAsc();
    Optional<User> findFirstByOrderByEmailDesc();
    List<User> findTop3ByOrderByEmailAsc();
    List<User> findTop3ByOrderByEmailDesc();
    List<User> findTop3ByName(String name);
    List<User> findFirst3ByName(String name);
    List<User> findTop3ByNameOrderByEmailAsc(String name);
    List<User> findTop3ByNameOrderByEmailDesc(String name);
    List<User> findFirst3ByNameOrderByEmailAsc(String name);
    List<User> findFirst3ByNameOrderByEmailDesc(String name);
    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameAndEmailOrderByNameAsc(String name, String email);
    List<User> findByNameAndEmailOrderByNameDesc(String name, String email);
    List<User> findByNameAndEmailOrderByNameAscEmailDesc(String name, String email);
    List<User> findByNameAndEmailOrderByNameDescEmailAsc(String name, String email);
    Optional<User> findByNameOrEmail(String name, String email);
    List<User> findByNameOrEmailOrderByNameAsc(String name, String email);
    List<User> findByNameOrEmailOrderByNameAscEmailDesc(String name, String email);
    List<User> findByNameOrEmailOrderByNameDescEmailAsc(String name, String email);
    Optional<User> findByNameNot(String name);
    List<User> findByNameNotOrderByNameAsc(String name);
    List<User> findByNameNotOrderByNameDesc(String name);
    List<User> findByNameNotOrderByNameAscEmailDesc(String name);
    List<User> findByNameNotOrderByNameDescEmailAsc(String name);
    Optional<User> findByNameNotAndEmailNot(String name, String email);
    List<User> findByNameNotAndEmailNotOrderByNameAsc(String name, String email);
    List<User> findByNameNotAndEmailNotOrderByNameDesc(String name, String email);
    List<User> findByNameNotAndEmailNotOrderByNameAscEmailDesc(String name, String email);
    List<User> findByNameNotAndEmailNotOrderByNameDescEmailAsc(String name, String email);
    Optional<User> findByNameNotOrEmailNot(String name, String email);
    List<User> findByNameNotOrEmailNotOrderByNameAsc(String name, String email);
    List<User> findByNameLikeOrEmailLikeOrderByEmailAscEmailDesc(String name, String email);
}