package com.bank.system.management.service;

import java.util.EmptyStackException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bank.system.management.model.Account;
import com.bank.system.management.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
    
	@Autowired
	AccountRepository accountRepository;
	
	
	
	public List<Account> getAllAccount(){
		return accountRepository.findAll();
		
	}
	
	public void addAccount(Account account){
		String pan=account.getPan();
		String acc=account.getAccountNumber();
		if((accountRepository.countByaccountNumber(pan)<4) && (accountRepository.findByaccountNumber(acc)== null))
		{
			accountRepository.save(account);
		}
		else 
		{
			throw new EmptyStackException();
		}
	}
	
	@Transactional
	public List<Account> findBypan(String pan) {
		
		return accountRepository.findBypan(pan);
	}
	
	@Transactional
	public boolean updateAccount(Account account) {
		return accountRepository.save(account) != null;
	}
	
	@Transactional
	public void deleteAccount(Account account) {
		accountRepository.delete(account);
	}
	
	
}