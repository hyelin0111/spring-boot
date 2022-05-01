package kvp.hyelin.springbootmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import kvp.hyelin.springbootmongo.account.Account;
import kvp.hyelin.springbootmongo.account.AccountRepository;

@SpringBootApplication
public class SpringBootMongoApplication {

//	@Autowired
//	MongoTemplate mongoTemplate;

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
			Account account = new Account();
			account.setEmail("hhlin@email.com");
			account.setUsername("hhlin");

//			mongoTemplate.insert(account);

			accountRepository.insert(account);

			System.out.println("finished");
		};
	}
}
