package com.kvc.joy.plugin.security.erbac.dao;

import java.util.Collection;
import java.util.Map;

import com.kvc.joy.plugin.security.erbac.model.po.TErbacGroup;
import com.kvc.joy.plugin.security.erbac.model.po.TErbacUser;


/**
 * 
 * @author 唐玮琳
 * @time 2012-6-28 下午7:54:15
 */
public interface IErbacUserRepository {

	Map<TErbacGroup, Collection<TErbacUser>> getUsersByGroupIds(Collection<String> groudIds);

}