package kvp.hyelin.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HumanRunner implements ApplicationRunner {

	// @Autowired
	// Human human;
	//
	// @Override
	// public void run(ApplicationArguments args) throws Exception {
	// 	System.out.println(human);
	// }

	// @Value("${human.name}")
	// private String name;
	//
	// @Value("${human.age}")
	// private int age;
	//
	// @Override
	// public void run(ApplicationArguments args) throws Exception {
	// 	System.out.println("================");
	// 	System.out.println(name);
	// 	System.out.println(age);
	// 	System.out.println("================");
	// }

	/* 4주차 외부설정 실습
	@Autowired
	HumanProperties humanProperties;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("================");
		System.out.println(humanProperties.getName());
		System.out.println(humanProperties.getAge());
		System.out.println("================");
	}
	*/

	// 4주차 Profile 실습
	@Autowired
	private String hello;

	@Autowired
	private HumanProperties humanProperties;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("================");
		System.out.println(hello);
		System.out.println(humanProperties.getName());
		System.out.println(humanProperties.getFullName());
		System.out.println("================");
	}
}
