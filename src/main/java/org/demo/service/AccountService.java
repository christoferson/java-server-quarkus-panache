package org.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.demo.ApplicationException;
import org.demo.model.Account;
import org.demo.repository.AccountRepository;
import org.jboss.logging.Logger;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

@ApplicationScoped
public class AccountService implements IAccountService {

	private static final Logger LOG = Logger.getLogger(AccountService.class);
	
	@Inject
	AccountRepository repository;
	
	@Override
	public List<Account> list(int pageNumber, int pageSize) {
		pageNumber = (pageNumber <= 0)? 1 : pageNumber;
		pageSize = (pageSize <= 0)? 1 : pageSize;
		
		PanacheQuery<Account> query = repository.findAll();
		query.page(Page.of(pageNumber - 1, pageSize));
		return query.list();
	}
	
	@Override
	public Account find(long id) {
		return repository.findById(id);
	}
	
	@Override
	public Account findByAccontNumber(long accountNumber) {
		PanacheQuery<Account> query = repository.find("accountNumber", accountNumber);
		Optional<Account> optAccount = query.firstResultOptional();
		if (optAccount.isEmpty()) {
			throw new ApplicationException();
		}
		return optAccount.get();
	}
	
	
	@Override
	@Transactional
	public Account register(Account account) {
		Objects.requireNonNull(account);
		repository.persist(account);
        return account;
	}
	
}
