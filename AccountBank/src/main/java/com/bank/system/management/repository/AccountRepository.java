package com.bank.system.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.system.management.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query(value= "select count(acc.pan) from Account as acc where acc.pan=?1",nativeQuery= true)
	int countByaccountNumber(String pan);
	
	List<Account> findBypan(String name);

}