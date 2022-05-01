package kvp.hyelin.springbootmongo.account;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void findByEmail() {
		Account account = new Account();
		account.setUsername("hyelin");
		account.setEmail("hyelin@email.com");

		accountRepository.save(account);

		Optional<Account> byId = accountRepository.findById(account.getId());
		assertThat(byId).isNotEmpty();

		Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
		assertThat(byEmail).isNotEmpty();
		assertThat(byEmail.get().getUsername()).isEqualTo("hhlin");
	}
}