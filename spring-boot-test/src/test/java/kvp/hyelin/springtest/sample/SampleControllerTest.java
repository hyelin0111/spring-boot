package kvp.hyelin.springtest.sample;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void hello() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("hello hhlin"))
			.andDo(print());
	}
}
*/

/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void hello() throws Exception {
		String result = testRestTemplate.getForObject("/hello", String.class);
		assertThat(result).isEqualTo("hello hhlin");
	}
}
*/

/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("kvp");

		String result = testRestTemplate.getForObject("/hello", String.class);
		assertThat(result).isEqualTo("hello kvp");
	}
}
*/

/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("kvp");

		webTestClient.get().uri("/hello").exchange()
			.expectStatus().isOk()
			.expectBody(String.class).isEqualTo("hello kvp");
	}
}
*/

/*
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("kvp");

		mockMvc.perform(get("/hello"))
			.andExpect(content().string("hello kvp"))
			.andDo(print());
	}
}
*/

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

	@Rule
	public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

	@Autowired
	MockMvc mockMvc;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("kvp");

		mockMvc.perform(get("/hello"))
			.andExpect(content().string("hello kvp"))
			.andDo(print());

		assertThat(outputCaptureRule.toString())
			.contains("hhlin")
			.contains("skip");
	}
}