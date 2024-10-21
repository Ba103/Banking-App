package in.balaji.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.balaji.Entity.Account;
import in.balaji.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account account2 = accountService.createAccount(account);
		return ResponseEntity.ok(account2);
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		Account byId = accountService.getById(id);
		return ResponseEntity.ok(byId);
	}

	@GetMapping("/account/all")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> allAccounts = accountService.getAll();
		return ResponseEntity.ok(allAccounts);
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestBody double amount) {
		Account deposit = accountService.deposit(id, amount);
		return ResponseEntity.ok(deposit);
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		String deleteById = accountService.deleteById(id);
		return ResponseEntity.ok(deleteById);
	}

}
