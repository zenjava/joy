package com.kvc.joy.core.init.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import com.googlecode.flyway.core.Flyway;
import com.kvc.joy.commons.lang.PackageTool;
import com.kvc.joy.commons.lang.string.StringTool;
import com.kvc.joy.commons.log.Log;
import com.kvc.joy.commons.log.LogFactory;
import com.kvc.joy.core.init.service.IJoyPlugin;
import com.kvc.joy.core.init.service.ISystemInitService;
import com.kvc.joy.core.init.support.JoyPropeties;
import com.kvc.joy.core.spring.utils.CoreBeanFactory;

/**
 * 
 * @author 唐玮琳
 * @time 2013-2-3 下午4:13:09
 */
@Service
public class JoyPluginsInitializer implements ISystemInitService, BeanPostProcessor {

	private List<IJoyPlugin> components = new ArrayList<IJoyPlugin>();
	private static Log logger = LogFactory.getLog(JoyPluginsInitializer.class);

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof IJoyPlugin) {
			register((IJoyPlugin) bean);
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public void init() {
		// 按初始化优先级从小到大排序
		Collections.sort(components, new Comparator<IJoyPlugin>() {

			public int compare(IJoyPlugin comp1, IJoyPlugin comp2) {
				return Integer.valueOf(comp1.getInitPriority()).compareTo(comp2.getInitPriority());
			}

		});
		
		// 初始化平台各插件
		for (IJoyPlugin component : components) {
			if (component.isEnabled()) {
				logger.info("启动JOY平台插件【" + component.getName() + "】...");
				
				// 实体字段注释和默认值同步到数据库
				String poPkg = component.getPoPackage();
				if(StringTool.isNotBlank(poPkg)) {
					CoreBeanFactory.getMdRdbAlterReverseSyncService().generate(poPkg);
				}
				
				// sql脚本安装
				Flyway flyway = CoreBeanFactory.getRdbObjectsInitService().createFlyway();
				String migrationPrefix = component.getSqlMigrationPrefix();
				flyway.setSqlMigrationPrefix(migrationPrefix);
				CoreBeanFactory.getRdbObjectsInitService().migrate(flyway);
				
				try {
					component.startup();
					logger.info("JOY平台插件【{0}】启动成功。", component.getName());
				} catch (Exception e) {
					logger.error(e, "JOY平台插件【{0}】启动失败！", component.getName());
				}
			} else {
				logger.info("JOY平台插件【{0}】未启动。", component.getName());
			}
		}
		
		// 应用sql脚本安装
		Flyway flyway = CoreBeanFactory.getRdbObjectsInitService().createFlyway();
		String migrationPrefix = JoyPropeties.FLYWAY_SQLMIGRATIONPREFIX;
		flyway.setSqlMigrationPrefix(migrationPrefix);
		CoreBeanFactory.getRdbObjectsInitService().migrate(flyway);
	}

	protected void register(IJoyPlugin component) {
		components.add(component);
	}

	public String getName() {
		return "JOY平台各插件启动管理";
	}
	
	public static String getCtxConfLocations() {
		StringBuilder sb = new StringBuilder();
		String DEFAULT_CFG_LOCATION = "classpath*:/conf/applicationContext*.xml";
		sb.append(DEFAULT_CFG_LOCATION);
//		sb.append(",").append("classpath*:/conf/springMVC.xml");
		Set<Class<?>> classes = PackageTool.getClassesInPackage("com.kvc.joy.core", true);
		classes.addAll(PackageTool.getClassesInPackage("com.kvc.joy.plugin", true));
		for (Class<?> clazz : classes) {
			if (clazz.getName().endsWith("Plugin") && IJoyPlugin.class.isAssignableFrom(clazz)) {
				try {
					IJoyPlugin plugin = (IJoyPlugin) clazz.newInstance();
					if(plugin.isEnabled()) {
						String loaction = plugin.getCtxConfLocation();
						sb.append(",").append(loaction);
					}
				} catch (Exception e) {
				}
			}
		}
		return sb.toString();
	}

}