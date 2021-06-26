package org.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity 
@NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Account a ORDER BY a.accountNumber")
@NamedQuery(name = "Accounts.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber ORDER BY a.accountNumber")
public class Account {

	@Id
	@SequenceGenerator(name = "accountsSequence", sequenceName = "accounts_id_seq", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountsSequence")
	private Long id;
	private Long accountNumber;
	private Long customerNumber;
	private String customerName;
	private BigDecimal balance;
	private AccountStatus accountStatus = AccountStatus.OPEN;
	@Version @Column(nullable = false)
    private long version = 0L;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public long getVersion() {
		return version;
	}

}
