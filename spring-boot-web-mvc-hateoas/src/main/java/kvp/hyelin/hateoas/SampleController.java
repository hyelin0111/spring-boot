package kvp.hyelin.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/hello")
	public EntityModel<Hello> hello() {
		Hello hello = new Hello();
		hello.setPrefix("Hey,");
		hello.setName("hhlin");

		EntityModel<Hello> helloResource = EntityModel.of(hello);
		// SampleController 클래스에서 제공하는 hello라는 메소드에 대한 링크를 따서
		// 이 링크를 self relation으로 만들어서 추가
		helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

		return helloResource;
	}
}
