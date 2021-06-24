package com.coderscampus.FinalProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.FinalProject.Service.TransactionService;
import com.coderscampus.FinalProject.Service.UserService;
import com.coderscampus.FinalProject.domain.Transaction;
import com.coderscampus.FinalProject.domain.User;



@Controller
public class CheckoutController {

		@Autowired
		private TransactionService transactionService;
		
		
		@GetMapping("/checkout")
		public String getTransaction(ModelMap model) {
			model.put("transaction", new Transaction());
			return "checkout";
		}
		
		@GetMapping("/menu")
		public String showMenu(ModelMap model) {
			Transaction trans = new Transaction();
			model.put("transaction", trans);
			return "menu";
		}
		@PostMapping("/checkout")
		public String postTransaction(Transaction trans) {
			transactionService.save(trans);
			return "redirect:/checkout";
		}
		@PostMapping("/menu")
		public String createTransaction(Transaction trans) {
			transactionService.createTrans(trans);
			return "redirect:/checkout";
		}
}
