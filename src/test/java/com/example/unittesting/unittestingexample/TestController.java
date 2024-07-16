package com.example.unittesting.unittestingexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.unittesting.unittestingexample.controller.WelcomeController;
import com.example.unittesting.unittestingexample.services.WelcomeService;

@WebMvcTest(value = WelcomeController.class)
public class TestController {

	@MockBean
	private WelcomeService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testwelcomemsg() throws Exception {
		when(service.welcomeMsg()).thenReturn("Hello testmmmmmmmmmmmmmm!!");
		//to prepare the request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/hello");
		//to send the request
		ResultActions perform = mockMvc.perform(reqBuilder);
		//result
		MvcResult mvcResult = perform.andReturn();
		//response
		MockHttpServletResponse response = mvcResult.getResponse();
		//response Status
		int status = response.getStatus();
		assertEquals(200,status);
	}
}
