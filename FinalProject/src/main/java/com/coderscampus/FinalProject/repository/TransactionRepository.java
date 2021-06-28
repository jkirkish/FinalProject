package com.coderscampus.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.FinalProject.domain.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
