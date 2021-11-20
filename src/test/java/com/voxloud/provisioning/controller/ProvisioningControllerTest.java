package com.voxloud.provisioning.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("unchecked")
public class ProvisioningControllerTest {

	@Test
	void contextLoads() {
	}

	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Test
	public void testDesk() throws Exception {
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get("/api/v1/provisioning/aa-bb-cc-dd-ee-ff"))
				.andExpect(status().isOk()).andReturn();

		assertTrue(mvcResult.getResponse().getStatus() == 200);
	}

	@Test
	public void testConference() throws Exception {
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get("/api/v1/provisioning/f1-e2-d3-c4-b5-a6"))
				.andExpect(status().isOk()).andReturn();

		assertTrue(mvcResult.getResponse().getStatus() == 200);
	}
	
	@Test
	public void testFailCase() throws Exception {
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get("/api/v1/provisioning/fail-mac-address"))
				.andExpect(status().isOk()).andReturn();

		assertFalse(mvcResult.getResponse().getStatus() == 200);
	}


}
