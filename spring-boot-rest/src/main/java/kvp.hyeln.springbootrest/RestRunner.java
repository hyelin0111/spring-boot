package kvp.hyeln.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner {

	// @Autowired
	// RestTemplateBuilder restTemplateBuilder;
	//
	// @Override
	// public void run(ApplicationArguments args) throws Exception {
	//
	// 	RestTemplate restTemplate = restTemplateBuilder.build();
	//
	// 	WebClient webClient = WebClient.builder().build();
	//
	// 	StopWatch stopWatch = new StopWatch();
	// 	stopWatch.start();
	//
	// 	// TODO /hello 호출
	// 	// 원하는 응답의 타입을 지정해주면 해당 타입으로 바로 결과를 가져올 수 있음
	// 	String helloResult = restTemplate.getForObject("http://localhost:8443/hello", String.class);
	// 	System.out.println(helloResult);
	//
	// 	// TODO /world 호출
	// 	String worldResult = restTemplate.getForObject("http://localhost:8443/world", String.class);
	// 	System.out.println(worldResult);
	//
	// 	stopWatch.stop();
	// 	System.out.println(stopWatch.prettyPrint());
	// }

	@Autowired
	WebClient.Builder builder;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		WebClient webClient = builder
			.baseUrl("http://localhost:8443")
			.build();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Mono<String> helloMono = webClient.get().uri("/hello")
			.retrieve()
			.bodyToMono(String.class);

		// 실제 요청 보내고 응답 가져오는 부분
		// subscribe 자체는 Non-Blocking
		helloMono.subscribe(s -> {
			// 응답이 오면 callback으로 이 부분이 실행되는 것
			System.out.println(s);

			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}

			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});

		Mono<String> worldMono = webClient.get().uri("/world")
			.retrieve()
			.bodyToMono(String.class);

		worldMono.subscribe(s -> {
			System.out.println(s);

			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}

			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
	}
}