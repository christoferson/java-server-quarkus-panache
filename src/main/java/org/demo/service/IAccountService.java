package org.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.demo.model.Account;

public interface IAccountService {
	
	List<Account> list(int pageNumber, int maxResults);
	
	Account find(long id);
	
	Account findByAccontNumber(long accountNumber);
	
	Account deposit(long id, BigDecimal amount);
	        
	Account withdraw(long id, BigDecimal amount);

	Account register(Account account);

}
