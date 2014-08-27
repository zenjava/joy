/* 用户帐号状态代码 */
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_USER_STATUS_00','1','1',null,null,null,null,null,null,'0',null,null,null,null,'00','用户帐号状态','user_status',null,null,'jin yong',null,'禁用',' forbidden');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_USER_STATUS_10','1','1',null,null,null,null,null,null,'0',null,null,null,null,'10','用户帐号状态','user_status',null,null,'zheng chang',null,'正常',' normal');

/* 初始化用户 */
insert into t_user_basic(id,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,update_dept,update_time,update_user,user_account,remark,last_login_time,login_count,user_name,password,sex_code,status_code,active,online_status)
values ('kevice_id',0,null,null,null,null,null,null,0,null,null,null,'kevice',null,null,null,'Kevice','6189808204556b0524045879df1cd739','1','01',1,0);


/* 登陆失败原因代码 */
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGIN_STATE_00','1','1',null,null,null,null,null,null,'0',null,null,null,null,'00','登陆状态','login_state',null,null,'deng lu cheng gong',null,'登陆成功','login successfully');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGIN_STATE_11','1','1',null,null,null,null,null,null,'0',null,null,null,null,'11','登陆状态','login_state',null,null,'mi ma cuo wu',null,'密码错误','password error');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGIN_STATE_12','1','1',null,null,null,null,null,null,'0',null,null,null,null,'12','登陆状态','login_state',null,null,'yan zheng ma cuo wu',null,'验证码错误','verification code error');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGIN_STATE_21','1','1',null,null,null,null,null,null,'0',null,null,null,null,'21','登陆状态','login_state',null,null,'zhang hao suo ding',null,'帐号被锁定','account lock');

/* 登出系统方式代码 */
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGOUT_METHOD_11','1','1',null,null,null,null,null,null,'0',null,null,null,null,'11','登出系统方式','logout_method',null,null,'dian ji tui chu an niu',null,'点击退出按钮','click exit button');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGOUT_METHOD_12','1','1',null,null,null,null,null,null,'0',null,null,null,null,'12','登出系统方式','logout_method',null,null,'zhi jie guan bi liu lan qi',null,'直接关闭浏览器','close broswer directly');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGOUT_METHOD_21','1','1',null,null,null,null,null,null,'0',null,null,null,null,'21','登出系统方式','logout_method',null,null,'chao shi',null,'超时','timeout');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us) 
values ('JOY_LOGOUT_METHOD_99','1','1',null,null,null,null,null,null,'0',null,null,null,null,'99','登出系统方式','logout_method',null,null,'qi ta',null,'其它','other');


/* ip限制类型 */
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_IP_LIMIT_TYPE_01','1','1',null,null,null,null,null,null,'0',null,null,null,null,'01','IP限制类型','ip_limit_type',null,null,'deng lu',null,'登陆','login');


/* 联系方式代码 */
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010000','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010000','联系方式','contact_way',null,null,'dian hua',null,'电话','telephone');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010100','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010100','联系方式','contact_way',null,'010000','gu ding dian hua',null,'固定电话','fixed-line telephone');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010200','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010200','联系方式','contact_way',null,'010000','yi dong dian hua',null,'移动电话','mobile phone');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010201','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010201','联系方式','contact_way',null,'010200','zhong guo dian xin',null,'中国电信','China Telecom');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010202','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010202','联系方式','contact_way',null,'010200','zhong guo yi dong',null,'中国移动','China Mobile');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010203','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010203','联系方式','contact_way',null,'010200','zhong guo lian tong',null,'中国联通','China Unicom');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_010299','1','1',null,null,null,null,null,null,'0',null,null,null,null,'010299','联系方式','contact_way',null,'010200','qi ta',null,'其它','other');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_019900','1','1',null,null,null,null,null,null,'0',null,null,null,null,'019900','联系方式','contact_way',null,'010000','qi ta',null,'其它','other');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020000','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020000','联系方式','contact_way',null,null,'wang luo zhang hao',null,'网络帐号','network account');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020100','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020100','联系方式','contact_way',null,'020000','ji shi tong xun',null,'即时通讯','instant messaging');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020101','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020101','联系方式','contact_way',null,'020100','qq',null,'QQ','QQ');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020102','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020102','联系方式','contact_way',null,'020100','wei xin',null,'微信','WeChat');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020199','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020199','联系方式','contact_way',null,'020100','qi ta',null,'其它','other');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020200','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020200','联系方式','contact_way',null,'020000','dian zi you xiang',null,'电子邮箱','email');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_020300','1','1',null,null,null,null,null,null,'0',null,null,null,null,'020300','联系方式','contact_way',null,'020000','you xi zhang hao',null,'游戏帐号','game account');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_030000','1','1',null,null,null,null,null,null,'0',null,null,null,null,'030000','联系方式','contact_way',null,null,'lian xi di zhi',null,'联系地址','address');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_030100','1','1',null,null,null,null,null,null,'0',null,null,null,null,'030100','联系方式','contact_way',null,'030000','chang zhu di zhi',null,'常住地址','permanent address');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_030200','1','1',null,null,null,null,null,null,'0',null,null,null,null,'030200','联系方式','contact_way',null,'030000','zan zhu di zhi',null,'暂住地址','temporary address');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_030300','1','1',null,null,null,null,null,null,'0',null,null,null,null,'030300','联系方式','contact_way',null,'030000','gong zuo di zhi',null,'工作地址','work address');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_039900','1','1',null,null,null,null,null,null,'0',null,null,null,null,'039900','联系方式','contact_way',null,'030000','qi ta',null,'其它','other');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_040000','1','1',null,null,null,null,null,null,'0',null,null,null,null,'040000','联系方式','contact_way',null,null,'lian xi di zhi you bian',null,'联系地址邮编','postcode');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_040100','1','1',null,null,null,null,null,null,'0',null,null,null,null,'040100','联系方式','contact_way',null,'040000','chang zhu di zhi you bian',null,'常住地址邮编','permanent address postcode');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_040200','1','1',null,null,null,null,null,null,'0',null,null,null,null,'040200','联系方式','contact_way',null,'040000','zan zhu di zhi you bian',null,'暂住地址邮编','temporary address postcode');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_040300','1','1',null,null,null,null,null,null,'0',null,null,null,null,'040300','联系方式','contact_way',null,'040000','gong zuo di zhi you bian',null,'工作地址邮编','work address postcode');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_049900','1','1',null,null,null,null,null,null,'0',null,null,null,null,'049900','联系方式','contact_way',null,'040000','qi ta',null,'其它','other');
insert into t_sys_codes(id,active,built_in,create_dept,create_time,create_user,delete_dept,delete_time,delete_user,deleted,remark,update_dept,update_time,update_user,code,group_comment,group_id,ordinal,parent_code,pin_yin,segment_rule,trans,trnas_en_us)
values ('JOY_CONTACT_WAY_990000','1','1',null,null,null,null,null,null,'0',null,null,null,null,'990000','联系方式','contact_way',null,null,'qi ta',null,'其它','other');


