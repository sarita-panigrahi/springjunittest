package org.sdrc.boot.web.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.sdrc.boot.web.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudControllerTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUserView_Test() throws Exception {

		CrudController c = new CrudController();
		ModelAndView mav = c.getUserView();
		Assert.assertEquals("userProfile.jsp", mav.getViewName());
		
//		mockMvc.perform(get("/getUsersView")).andExpect(status().isOk()).andExpect(view().name("userProfile"));
	}

	@Test
	@Transactional
	public void shouldAdd_MstUser_ToDb_Controller_Test() throws Exception {
		
		String userName = TestUtil.createStringWithLength(5);
		String name = TestUtil.createStringWithLength(5);

		// mockMvc.perform(post("/saveUser/sarita123")).andDo(print()).andExpect(status().isOk())
		// .andExpect(content().string(containsString("sarita123")));

		mockMvc.perform(post("/saveUser").param("userName", userName).param("name", name)).andDo(print()).andExpect(status().isOk())
				 .andExpect(content().string(containsString(userName)));
		
		/*mockMvc.perform(post("/saveUser").param("userName", userName).param("name", name)).andDo(print()).andExpect(status().isOk())
		 .andExpect(content().string(is(userName)));*/
		
	}
}
