package com.bank.system.management;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.system.management.model.Account;
import com.bank.system.management.repository.AccountRepository;
import com.bank.system.management.service.AccountService;
@SpringBootTest
@RunWith(SpringRunner.class)
class AccountBankApplicationTests {
	@Autowired
	private AccountService accountService;
	@MockBean
	AccountRepository accountRepository;
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void getAllAccountTest(){
		when(accountRepository.findAll()).thenReturn(Stream
				.of(new Account(344,"HDFC","1234567890","abc","def","BNZAA2318J"),new Account(345,"Axis","1234567891","ghi","jkl","BNZAA2318A")).collect(Collectors.toList()));
	assertEquals(2, accountService.getAllAccount().size());
	}
	@Test
	public void findBypanTest() {
		String name= "BNZAA2318J";
		when(accountRepository.findBypan(name)).thenReturn(Stream.of(new Account(345,"Axis","1234567891","ghi","jkl","BNZAA2318A")).collect(Collectors.toList()));
		assertEquals(1, accountService.findBypan(name).size());
	}
	@Test
	public void deleteTest(){
		Account account = new Account(345,"Axis","1234567891","ghi","jkl","BNZAA2318A");
		accountRepository.delete(account);
		verify(accountRepository, times(1)).delete(account);
	}
	@Test
	public void addAccountTest() {
		 {
		        Account acc = new Account(349,"Axis","1234567891","ghi","jkl","BNZAA2318A");
		         
		        accountService.addAccount(acc);
		         
		        verify(accountRepository, times(1)).save(acc);
		    }

		}

}
