package com.jpa.course1.io.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.course1.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{

	UserEntity findByEmail(String email);
}
