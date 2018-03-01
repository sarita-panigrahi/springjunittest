package org.sdrc.boot.web.util;

import org.springframework.context.ApplicationEvent;

public interface StateManager {

	Object getValue(String key);
	
	void setValue(String Key, Object Value);

	void onApplicationEvent(ApplicationEvent event);

}