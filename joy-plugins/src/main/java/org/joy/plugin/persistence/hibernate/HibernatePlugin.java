package org.joy.plugin.persistence.hibernate;

import org.joy.core.init.service.IPlugin;
import org.joy.core.init.support.properties.JoyProperties;
import org.springframework.stereotype.Component;

/**
 * hibernate插件，封装一些hibernate常用操作
 * 
 * @since 1.0.0
 * @author Kevice
 * @time 2013年10月3日 下午8:36:42
 */
@Component
public class HibernatePlugin implements IPlugin {

	@Override
	public String getName() {
		return "Hibernate";
	}

	@Override
	public int getInitPriority() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void startup() {
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		return JoyProperties.PLUGIN_PERSISTENCE_HIBERNATE_ENABLED;
	}

	@Override
	public String getSqlMigrationPrefix() {
		return "HIBERNATE";
	}

	@Override
	public String getPoPackage() {
		return null;
	}

	@Override
	public String getCtxConfLocation() {
		return "classpath*:/conf/plugin-appCtx-hibernate.xml";
	}

}
