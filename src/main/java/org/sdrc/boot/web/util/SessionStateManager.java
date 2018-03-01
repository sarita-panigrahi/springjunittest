package org.sdrc.boot.web.util;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Scope(value = "singleton")
public class SessionStateManager implements StateManager, ApplicationListener<ApplicationEvent> {

	public SessionStateManager() {
	}

	@Override
	public Object getValue(String key) {
		return session().getAttribute(key);
	}

	@Override
	public void setValue(String key, Object value) {
		session().setAttribute(key, value);
	}

	private HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
	}

}
