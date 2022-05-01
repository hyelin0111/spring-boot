package kvp.hyelin.springbootsecuritycustomizing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kvp.hyelin.springbootsecuritycustomizing.account.Account;
import kvp.hyelin.springbootsecuritycustomizing.account.AccountService;

@Component
public class AccountRunner implements ApplicationRunner {

	@Autowired
	AccountService accountService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account hhlin = accountService.createAccount("hhlin", "1234");
		System.out.println(hhlin.getUsername() + " password: " + hhlin.getPassword());
	}
}
