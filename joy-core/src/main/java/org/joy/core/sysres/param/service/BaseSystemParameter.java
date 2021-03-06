package org.joy.core.sysres.param.service;

import org.joy.commons.enums.YesNot;
import org.joy.commons.lang.DateTool;
import org.joy.core.sysres.SysResTool;

/**
 * 系统参数基类，各应用系统可以继承该类，实现自己的个性参数。    <br>
 * 注意应该在子类调用该类的init方法，否则该类的参数不会被初始化。<br>
 * 这些参数几乎都是事先存在数据库、配置文件中，然后调用init方法进行初始化的。<br>
 * 某些参数是在该类定义，但必须由各应用进行初始化的。
 *
 * @since 1.0.0
 * @author Kevice
 * @time 2013-2-7 下午10:36:55
 */
public class BaseSystemParameter {

	// 可能需要在子类进行初始化的参数
	/** 版本号 */
	public static String PRO_EDITION;
	/** 系统名称; */
	public static String APP_NAME;
	/** 最大的客户端数,默认为10个客户端数; */
	public static int MAX_CLIENT = 10;
	/** 服务器信息 如: IBM WebSphere Application Server/6.1 Apache Tomcat/5.0.28 */
	public static String SERVER_INFO = "";
	
	// 从各参数表加载的参数
	/** 故意抛出异常以便跟踪栈轨迹的开关 */
	public static boolean THROW_TO_PRINT_TRACE_SWITCH;
	/** 网页显示最大结果数(记录数) */
	public static int FETCH_MAX_VALUE_IN_WEB;
	/** 字符集,不同字符集使用不同的加密算法 */
	public static String DATABASE_CHARSET;
	/** 密码类型 */
	public static String PASSWORD_TYPE;
	/**系统启动时间*/
	public static String SYSTEM_STARTUP_TIME;
	
	/**
	 * 初始化系统参数
	 */
	public static void init() {
		THROW_TO_PRINT_TRACE_SWITCH = YesNot.YES.getBinary().equals(SysResTool.getParamValue("THROW_TO_PRINT_TRACE_SWITCH"));
		FETCH_MAX_VALUE_IN_WEB = Integer.parseInt(SysResTool.getParamValue("FETCH_MAX_VALUE_IN_WEB"));
		DATABASE_CHARSET = SysResTool.getParamValue("DATABASE_CHARSET");
		PASSWORD_TYPE = SysResTool.getParamValue("PASSWORD_TYPE");
		SYSTEM_STARTUP_TIME = DateTool.currentDate(DateTool.UNFMT_yyyyMMddHHmmss);
	}
	
	
}
