package in.balaji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.balaji.Entity.Account;
import in.balaji.Repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accoutRepo;

	@Override
	public Account createAccount(Account account) {
		Account save = accoutRepo.save(account);
		return save;
	}

	@Override
	public Account getById(Long id) {
		Optional<Account> findById = accoutRepo.findById(id);
		if (findById.isEmpty()) {
			return findById.get();
		}

		return null;
	}

	@Override
	public List<Account> getAll() {
		List<Account> allAccounts = accoutRepo.findAll();
		return allAccounts;
	}

	@Override
	public Account deposit(Long id, double amount) {
		Account account = accoutRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accoutRepo.save(account);
		return savedAccount;
	}

	@Override
	public String deleteById(Long id) {
		if (accoutRepo.existsById(id)) {
			accoutRepo.deleteById(id);
			return "successfully deleted";
		} else {
			return "Account not exists";
		}

	}

}
