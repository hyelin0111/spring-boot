package kvp.hyelin.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HumanProperties.class)
public class HumanConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public Human human(HumanProperties properties) {
		Human human = new Human();
		human.setName(properties.getName());
		human.setAge(properties.getAge());

		return human;
	}
}
