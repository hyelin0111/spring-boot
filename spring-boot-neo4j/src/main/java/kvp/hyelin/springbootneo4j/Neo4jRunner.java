package kvp.hyelin.springbootneo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kvp.hyelin.springbootneo4j.account.Account;
import kvp.hyelin.springbootneo4j.account.AccountRepository;
import kvp.hyelin.springbootneo4j.account.Role;

@Component
public class Neo4jRunner implements ApplicationRunner {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Account account = new Account();
		account.setEmail("admin@mail.com");
		account.setUsername("Admin");

		Role role = new Role();
		role.setName("admin");

		account.getRoles().add(role);

		accountRepository.save(account);

		System.out.println("finished");
	}
}
