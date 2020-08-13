package com.bank.system.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.system.management.model.Account;
import com.bank.system.management.repository.AccountRepository;
import com.bank.system.management.service.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository repo;
	
	@GetMapping("/accounts")
	public List<Account> getAccounts(){
		return accountService.getAllAccount();
	}
	
	@PostMapping("/addAccount")
	public void addAccount(@Valid @RequestBody Account account) {
		accountService.addAccount(account);
	}
	
	@GetMapping("/count/{pan}")
	public int value(@PathVariable String pan) {
		return repo.countByaccountNumber(pan);
	}
	
	@RequestMapping(value = "/AccByPan/{pan}", method = RequestMethod.GET)
	public List<Account> getallAccountdetails(@PathVariable String pan) {
		return accountService.findBypan(pan) ;
	}
	
	@RequestMapping(value = "/updateAcc", method = RequestMethod.PUT)
	public HttpStatus updateRestaurant(@RequestBody Account account) {
		return accountService.updateAccount(account)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteAcc/{accnum}", method = RequestMethod.DELETE)
	public String delete(@RequestBody Account account, @PathVariable String accnum) {
		accountService.deleteAccount(account);
		return "deleted";
	}
}
