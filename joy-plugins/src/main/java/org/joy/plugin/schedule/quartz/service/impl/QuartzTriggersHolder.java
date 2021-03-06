package org.joy.plugin.schedule.quartz.service.impl;

import org.joy.commons.lang.DateTool;
import org.joy.commons.lang.string.StringTool;
import org.joy.plugin.schedule.quartz.dao.TQrtzJobPlanDao;
import org.joy.plugin.schedule.quartz.model.po.TQrtzJobPlan;
import org.joy.plugin.schedule.quartz.service.IQuartzTriggersHolder;
import org.quartz.CronTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * quartz触发器持有者
 *
 * @since 1.0.0
 * @author Kevice
 * @time 2013-2-17 下午6:50:05
 */
public class QuartzTriggersHolder implements IQuartzTriggersHolder {
	
	@Autowired
	private TQrtzJobPlanDao qrtzJobPlanCfgDao;
	private final Map<TriggerKey, Trigger> triggerMap = new HashMap<TriggerKey, Trigger>();
	
	public void loadTriggers() {
		List<TQrtzJobPlan> plans = qrtzJobPlanCfgDao.getEffectPlans();
		Date now = new Date();
		
		for (TQrtzJobPlan plan : plans) {
			CronTrigger trigger = newTrigger()
		            .withIdentity(plan.getId())
		            .withSchedule(cronSchedule(plan.getCronExp()))
		            .startAt(StringTool.isBlank(plan.getEffectTime()) ? now : DateTool.parseDate(plan.getEffectTime(), DateTool.UNFMT_yyyyMMddHHmmss))
		            .endAt(StringTool.isBlank(plan.getExpireTime()) ? null : DateTool.parseDate(plan.getExpireTime(), DateTool.UNFMT_yyyyMMddHHmmss))
		            .build();
			triggerMap.put(new TriggerKey(plan.getId()), trigger);
		}
	}
	
	public Map<TriggerKey, Trigger> getTriggerMap() {
		return triggerMap;
	}
	
	public void setQrtzJobPlanCfgDao(TQrtzJobPlanDao qrtzJobPlanCfgDao) {
		this.qrtzJobPlanCfgDao = qrtzJobPlanCfgDao;
	}
	
	public Trigger getTrigger(String triggerId) {
		return triggerMap.get(new TriggerKey(triggerId));
	}

}
