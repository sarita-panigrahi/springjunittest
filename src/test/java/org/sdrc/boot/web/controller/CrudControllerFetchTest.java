package org.sdrc.boot.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.repository.MstUserRepository;
import org.sdrc.boot.web.service.MainService;
import org.sdrc.boot.web.service.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudControllerFetchTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@InjectMocks
	private MainServiceImpl mainServiceImplMock;
	
	@MockBean(name="mstUserRepository")
	private MstUserRepository mstUserRepository;
	
	@Mock
	private MainService mainServiceMock;

	private String userName = "junit";
	private MstUser junitAlex;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		
		MockitoAnnotations.initMocks(this);
		
		junitAlex = new MstUser(userName);
		
		doReturn(Arrays.asList(junitAlex, junitAlex)).when(mstUserRepository).findAll();
		doReturn(Arrays.asList(junitAlex, junitAlex)).when(mainServiceMock).getUsers();
	}

	@Test
	public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {
	     
		MstUser junitUser = new MstUser(userName);
	  
//	    when(mstUserRepositoryMock.findAll()).thenReturn(Arrays.asList(junitUser, junitUser));
//	    when(mainServiceMock.getUsers()).thenReturn(Arrays.asList(junitUser, junitUser));
	    
//	    given(mainServiceMock.getUsers()).willReturn(Arrays.asList(junitUser, junitUser));
	    mockMvc.perform(get("/getUsers")
	      .contentType(MediaType.APPLICATION_JSON_UTF8))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(jsonPath("$[0].userName", is(junitUser.getUserName())));
	}
}
