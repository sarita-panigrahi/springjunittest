package org.sdrc.boot.web.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.repository.MstUserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainServiceImplTest {

	@Mock
	private MstUserRepository mstUserRepository;

	@InjectMocks
	private MainServiceImpl mainServiceMock;

	private String userName = "junit";
	private MstUser junitAlex;

	@Before
	public void setUp() {

		junitAlex = new MstUser(userName);
		doReturn(junitAlex).when(mstUserRepository).findByUserName(junitAlex.getUserName());
	}

	@Test
	public void whenValidUserName_thenUserShouldBeFound() {
		MstUser found = mainServiceMock.findByName(userName);

		assertThat(found.getUserName()).isEqualTo(userName);
	}

}
