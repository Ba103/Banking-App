package in.balaji.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.balaji.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
