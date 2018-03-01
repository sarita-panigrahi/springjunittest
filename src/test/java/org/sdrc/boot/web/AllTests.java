package org.sdrc.boot.web;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.sdrc.boot.web.controller.CrudControllerFetchTest;
import org.sdrc.boot.web.controller.CrudControllerTest;
import org.sdrc.boot.web.controller.MainControllerTest;
import org.sdrc.boot.web.service.MainServiceImplTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@RunWith(Suite.class)
@SuiteClasses({CrudControllerTest.class, CrudControllerFetchTest.class, 
		MainControllerTest.class, MainServiceImplTest.class })
public class AllTests extends AbstractTransactionalJUnit4SpringContextTests{

}
