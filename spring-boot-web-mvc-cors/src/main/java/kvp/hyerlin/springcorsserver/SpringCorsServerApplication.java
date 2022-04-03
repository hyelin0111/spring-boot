package kvp.hyerlin.springcorsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCorsServerApplication {

	@CrossOrigin(origins = "http://localhost:8443")
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCorsServerApplication.class, args);
	}
}
