package com.coderscampus.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.FinalProject.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
