package org.joy.plugin.monitor.jdbc.jwebap.model.vo;

import org.joy.commons.log.ILogParam;
import org.joy.plugin.monitor.jdbc.jwebap.service.IPreparedSqlConvertor;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 参数信息
 *
 * @since 1.0.0
 * @author Kevice
 * @time 2012-12-15 下午7:09:20
 */
public class ParamMsg implements ILogParam {

	private String sql; // 不带参的sql语句
	private String fullSql; // 完整的sql语句(带参)
	private String vars;  // sql语句参数
	private long costTime; // sql语句执行耗费的时间
	
	public ParamMsg() {
	}
	
	public ParamMsg(String sql) {
		this.sql = sql;
	}
	
	public ParamMsg(String sql, long costTime) {
		this.sql = sql;
		this.costTime = costTime;
		this.fullSql = sql;
	}
	
	public ParamMsg(IPreparedSqlConvertor convertor, long costTime) {
		this.sql = convertor.getSql();
		this.fullSql = convertor.convert();
		this.vars = getSqlParams(convertor.getParams());
		this.costTime = costTime;
	}
	
	private String getSqlParams(List<String> params) {
		String sql = params.toString().replaceFirst("^\\[", "").replaceFirst("\\]$", "");
		return StringUtils.replace(sql,"'","");
	}
	
	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}
	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	/**
	 * @return the costTime
	 */
	public long getCostTime() {
		return costTime;
	}
	/**
	 * @param costTime the costTime to set
	 */
	public void setCostTime(long costTime) {
		this.costTime = costTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return costTime + "ms, " + fullSql;
	}

	public String getFullSql() {
		return fullSql;
	}

	public void setFullSql(String fullSql) {
		this.fullSql = fullSql;
	}

	public String getVars() {
		return vars;
	}

	public void setVars(String vars) {
		this.vars = vars;
	}
	
}
