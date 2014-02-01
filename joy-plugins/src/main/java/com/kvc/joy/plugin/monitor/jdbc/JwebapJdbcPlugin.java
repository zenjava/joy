package com.kvc.joy.plugin.monitor.jdbc;

import com.kvc.joy.core.init.service.IJoyPlugin;
import com.kvc.joy.core.init.support.JoyPropeties;
import com.kvc.joy.plugin.monitor.jdbc.model.po.TSysSqlLog;
import org.jwebap.startup.Startup;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * 
 * @author 唐玮琳
 * @time 2013-2-5 上午12:39:07
 */
 @Component
public class JwebapJdbcPlugin implements IJoyPlugin {

	public String getName() {
		return "Jwebap JDBC监控";
	}

	public void startup() {
		
	}
	
	//TODO
	public static void preInit() {
		URL url = JwebapJdbcPlugin.class.getClassLoader().getResource("conf/jwebap.xml");
		Startup.startup(url);
	}

	public void destroy() {
	}

	public boolean isEnabled() {
		return JoyPropeties.PLUGIN_JWEBAP_JDBC_ENABLED;
	}

	public int getInitPriority() {
		return 0;
	}

	@Override
	public String getSqlMigrationPrefix() {
		return "JWEBAP_JDBC";
	}

	@Override
	public String getPoPackage() {
		return TSysSqlLog.class.getPackage().getName();
	}
	
	@Override
	public String getCtxConfLocation() {
		return "classpath*:/conf/plugin-appCtx-jwebap-jdbc.xml";
	}

}
