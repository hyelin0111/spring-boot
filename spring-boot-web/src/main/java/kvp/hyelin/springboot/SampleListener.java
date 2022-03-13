package kvp.hyelin.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/* 4주차 EventListener 실습
@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("=======================");
		System.out.println("Application is started");
		System.out.println("=======================");
	}
}
*/

/*
4주차 ApplicationArguments 실습
@Component
public class SampleListener {

	public SampleListener(ApplicationArguments arguments) {
		System.out.println("foo: " + arguments.containsOption("foo"));
		System.out.println("bar: " + arguments.containsOption("bar"));
	}
}
*/

// 4주차 ApplicationRunner 실습
@Component
public class SampleListener implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("foo: " + args.containsOption("foo"));
		System.out.println("bar: " + args.containsOption("bar"));
	}
}