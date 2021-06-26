package org.demo.repository;

import javax.enterprise.context.ApplicationScoped;

import org.demo.model.Account;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<Account> {
	public Account findByAccountNumber(Long accountNumber) {
		return find("accountNumber = ?1", accountNumber).firstResult();
	}
}
