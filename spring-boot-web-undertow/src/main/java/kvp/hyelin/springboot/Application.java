package kvp.hyelin.springboot;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
// import org.springframework.context.annotation.Bean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// import org.apache.catalina.connector.Connector;

@SpringBootApplication
@RestController
public class Application {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.sources(Application.class)
			.banner((environment, sourceClass, out) -> {
				out.println("=================");
				out.println("printBanner Test");
				out.println("=================");
			})
			.run(args);
	}

	// @Bean
	// public ServletWebServerFactory serverFactory() {
	// 	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	// 	tomcat.addAdditionalTomcatConnectors(createStandardConnector());
	// 	return tomcat;
	// }
	//
	// private Connector createStandardConnector() {
	// 	Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	// 	connector.setPort(8081);
	// 	return connector;
	// }

}