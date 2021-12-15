package com.belong.telecom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void smokeTest() throws Exception {
		this.mvc.perform(get("/i-do-not-exist").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

}
