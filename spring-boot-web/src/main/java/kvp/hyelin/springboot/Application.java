package kvp.hyelin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		// app.addListeners(new SampleListener());
		app.run(args);
	}

	@Bean
	public Human human() {
		Human human = new Human();
		human.setName("hhlin");
		human.setAge(22);

		return human;
	}
}
