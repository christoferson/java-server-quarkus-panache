package org.demo.service;

import java.util.List;

import org.demo.model.Account;

public interface IAccountService {
	
	List<Account> list(int pageNumber, int maxResults);
	
	Account find(long id);
	
	Account findByAccontNumber(long accountNumber);

	Account register(Account account);

}
