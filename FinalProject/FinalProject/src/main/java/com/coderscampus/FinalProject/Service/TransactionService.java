package com.coderscampus.FinalProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.FinalProject.domain.Transaction;
import com.coderscampus.FinalProject.domain.User;
import com.coderscampus.FinalProject.repository.TransactionRepository;
import com.coderscampus.FinalProject.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transRepo;
	
	public Transaction createTrans(Transaction trans) {
		Long id = trans.getTransactionId();
		trans.setTransactionId(id);
		return transRepo.save(trans);
	}
	
	public Transaction save(Transaction trans) {
		return transRepo.save(trans);
	}
	
	public List<Transaction>findAll (){
		return transRepo.findAll();
	}
	public Transaction findById(Long transactionId)
	{	
		Optional<Transaction> transOpt = transRepo.findById(transactionId);
		return transOpt.orElse(new Transaction());
	}
	public void delete(Long transactionId) {
		transRepo.deleteById(transactionId);	
		
	}

}
