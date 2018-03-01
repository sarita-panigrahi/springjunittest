package org.sdrc.boot.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.sdrc.boot.web.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ConfigProperties configProperties;

	private MockMvc mockMvc;

	private final String username = "sarita";
	private final String password = "asdf";

	private final String inValidUsername = "saritas";

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_login_authorize() throws Exception {
		mockMvc.perform(get("/login").param("username", username).param("password", password)).andDo(print())
				.andExpect(status().isFound())
				.andExpect(
						MockMvcResultMatchers.flash().attribute("formSucess", configProperties.getValidCredentials()))
				.andExpect(redirectedUrl("/"));
	}

	@Test
	public void test_login_failed() throws Exception {

		mockMvc.perform(get("/login").param("username", inValidUsername).param("password", password)).andDo(print())
				.andExpect(status().isFound())
				.andExpect(
						MockMvcResultMatchers.flash().attribute("formError", configProperties.getInvalidCredentials()))
				.andExpect(redirectedUrl("/"));
		// thrown.expect(BadCredentialsException.class);
	}
}
