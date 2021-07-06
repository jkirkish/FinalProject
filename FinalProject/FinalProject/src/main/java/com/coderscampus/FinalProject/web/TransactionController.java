package com.coderscampus.FinalProject.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.FinalProject.Service.TransactionService;
import com.coderscampus.FinalProject.Service.UserService;
import com.coderscampus.FinalProject.domain.Transaction;
import com.coderscampus.FinalProject.domain.User;



@Controller
public class TransactionController {

		@Autowired
		private TransactionService transactionService;
		/*th:if="${#lists.size(transactions) != 1}"*/
		//th:unless="${#lists.size(users) != 1}"
		//th:action="@{/transactions/{transactionId}/delete(transactionId=${transaction.transactionId})}"
		@GetMapping("/transactions")
		public String getAllTransact(ModelMap model)
		{
			List<Transaction> transactions = transactionService.findAll();
			model.put("transactions", transactions);
			return "transactions";
		}
		
		@GetMapping("/transactions/{transactionId}")
		public String getOneTransaction (ModelMap model, @PathVariable Long transactionId)
		{
			Transaction trans = transactionService.findById(transactionId);
			model.put("transactions", Arrays.asList(trans));
			model.put("transaction",trans);
			return "transactions";	
		}
		@PostMapping("/transactions/{transactionId}")
		public String postOneTransaction (Transaction trans) {
			transactionService.saveTransaction(trans);
			return "redirect:/transactions/"+trans.getTransactionId();
		}
		
		@PostMapping("/transactions")
		public String postCreateUser(Transaction transaction) {
			System.out.println(transaction);
			transactionService.saveTransaction(transaction);
			return "redirect:/transactions";
		}
		@PostMapping("/transactions/{transactionId}/delete")
		public String deleteTransaction(@PathVariable Long transactionId)
		{
			transactionService.delete(transactionId);
			return "redirect:/transactions";
		}
		
		@GetMapping("/menu")
		public String showMenu(ModelMap model) {
			Transaction trans = new Transaction();
			model.put("transaction", trans);
			return "menu";
		}
		@PostMapping("/menu")
		public String postTransaction() {
			return "redirect:/transactions";
		}
		
}
