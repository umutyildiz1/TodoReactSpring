package com.example.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.domain.User;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {

    Optional<User> findById(String firstName);
}
