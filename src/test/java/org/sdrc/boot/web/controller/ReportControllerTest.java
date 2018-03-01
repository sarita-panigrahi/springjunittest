package org.sdrc.boot.web.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sdrc.boot.web.config.ConfigProperties;
import org.sdrc.boot.web.core.Authorize;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.service.UserService;
import org.sdrc.boot.web.util.StateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@PrepareForTest(fullyQualifiedNames = "org.sdrc.boot.web.util.*")
public class ReportControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@MockBean(name="stateManager")
	private StateManager stateManager;
	
//	@InjectMocks
//	private AuthorizeInterceptor authorizeInterceptor;
	
//	protected MockHttpSession session;
//
//	protected MockHttpServletRequest request;

	@Autowired
	private ConfigProperties configProperties;
	
	private UserModel um = null;
	
	@Before
	public void setUp() {
		 this.mockMvc =  MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
//				.addFilters(this.springSecurityFilterChain).build();
		
		MockitoAnnotations.initMocks(this);
		when(stateManager.getValue(configProperties.getUserPrincipal())).thenReturn(getUserModel());

	}

//	@Authorize(feature = "authfeature", permission = "authpermission")
	@Test
	public void test() throws Exception {

//		SessionStateManager stateManagerMock = mock(SessionStateManager.class);
//		PowerMockito.whenNew(SessionStateManager.class).withNoArguments().thenReturn(stateManagerMock);
//		stateManager.setValue(configProperties.getUserPrincipal(), um);
		
		mockMvc.perform(get("/getReportFile").param("reporttypeId", "1")).andDo(print()).andExpect(status().isOk());
	}

	public UserModel getUserModel(){
		um = new UserModel();
		um.setUserID((long) 10);
		um.setUserFirstName("robo");
		um.setUserName("robo_julie");
		um.setPassword("julie123");
		
		return um;
	}
}
