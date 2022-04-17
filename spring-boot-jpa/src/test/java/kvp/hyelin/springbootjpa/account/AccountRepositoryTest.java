package kvp.hyelin.springbootjpa.account;

import static org.assertj.core.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import kvp.hyelin.springbootjpa.acount.Account;
import kvp.hyelin.springbootjpa.acount.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void di() throws SQLException {

		/*
		try (Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getDriverName());
			System.out.println(metaData.getUserName());
		}
		*/

		Account account = new Account();
		account.setUsername("hhlin");
		account.setPassword("pass");

		Account newAccount = accountRepository.save(account);
		assertThat(newAccount).isNotNull();

		Account existingAcount = accountRepository.findByUsername(newAccount.getUsername());
		assertThat(existingAcount).isNotNull();

		Account nonEexistingAcount = accountRepository.findByUsername("test");
		assertThat(nonEexistingAcount).isNull();
	}
}
