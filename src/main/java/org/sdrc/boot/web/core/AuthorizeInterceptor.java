package org.sdrc.boot.web.core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sdrc.boot.web.config.ConfigProperties;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.util.StateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Sarita Panigrahi(sarita@sdrc.co.in)
 *
 */
@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	private final StateManager stateManager;

	@Autowired
	public AuthorizeInterceptor(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
//	@Autowired
//	private StateManager stateManager;

	@Autowired
	private ConfigProperties configProperties;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {

		UserModel user = (UserModel) stateManager.getValue(configProperties.getUserPrincipal());

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		Authorize authorize = ((HandlerMethod) handler).getMethodAnnotation(Authorize.class);

		if (authorize == null)
			return true;

		if (user == null)
			throw new AccessDeniedException(configProperties.getUnauthorized());

		String feature = authorize.feature();
		String permission = authorize.permission();
		//
		if(feature.contains("authfeature") && permission.equals("authpermission")) return true;
		
		return false;
	}

}
