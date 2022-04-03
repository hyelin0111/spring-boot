package kvp.hyelin.springbootexception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping("/hello")
	public String hello() {
		throw new SampleExcption();
	}

	@ExceptionHandler(SampleExcption.class)
	public @ResponseBody AppError sampleError(SampleExcption e) {
		AppError appError = new AppError();
		appError.setMessage("error.app.key");
		appError.setReason("IDK IDK IDK");

		return appError;
	}
}
