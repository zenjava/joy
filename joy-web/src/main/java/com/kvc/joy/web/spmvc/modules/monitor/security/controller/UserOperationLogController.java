package com.kvc.joy.web.spmvc.modules.monitor.security.controller;

import com.kvc.joy.web.spmvc.core.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @since 1.0.0
 * @author 唐玮琳
 * @time 2013年11月30日 下午11:29:09
 */
@Controller
@RequestMapping("/userOperationLog")
public class UserOperationLogController extends BaseController {

	@Override
	protected String getCurrentViewName() {
		return "joy/core/monitor/security/userOperationLog";
	}

}
