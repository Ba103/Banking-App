package in.balaji.service;

import java.util.List;

import in.balaji.Entity.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Account getById(Long id);

	public List<Account> getAll();

	public Account deposit(Long id, double balance);
	
	public String deleteById(Long id);
	

}
