--   -----------------  系统管理模块  ------------------------
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
id BIGINT ( 20 ) NOT NULL AUTO_INCREMENT,
account VARCHAR ( 32 ) NOT NULL,
name VARCHAR ( 32 ) NOT NULL COMMENT '用户名',
password VARCHAR ( 100 ) NULL DEFAULT NULL COMMENT '密码',
salt VARCHAR ( 20 ) NULL DEFAULT NULL COMMENT '盐',
sex INT ( 1 ) NULL DEFAULT NULL COMMENT '性别',
email VARCHAR ( 100 ) NULL DEFAULT NULL COMMENT '邮箱',
mobile VARCHAR ( 100 ) NULL DEFAULT NULL COMMENT '手机号',
status TINYINT ( 4 ) NULL DEFAULT NULL COMMENT '状态  0：正常   1：禁用',
dept_id BIGINT ( 20 ) NULL DEFAULT NULL COMMENT '部门ID',
dept_name VARCHAR ( 128 ) NULL DEFAULT NULL COMMENT '部门名称',
create_user VARCHAR ( 32 ) NULL DEFAULT NULL COMMENT '创建人',
create_user_name VARCHAR ( 32 ) NULL DEFAULT NULL COMMENT '创建人名称',
create_time timestamp ( 6 ) NULL DEFAULT NULL COMMENT '创建时间',
modify_user VARCHAR ( 32 ) NULL DEFAULT NULL,
modify_time timestamp ( 6 ) NULL DEFAULT NULL,
PRIMARY KEY ( id ) USING BTREE,
UNIQUE INDEX sys_user_100 ( account ) USING BTREE
)  COMMENT = '系统用户';


DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_code varchar(255) NULL DEFAULT NULL,
  role_name varchar(100) NULL DEFAULT NULL COMMENT '角色名称',
  remark varchar(100)  NULL DEFAULT NULL COMMENT '备注',
  create_user varchar(32) NULL DEFAULT NULL,
  create_user_name varchar(32) NULL DEFAULT NULL,
  create_time timestamp(6) NULL DEFAULT NULL,
  modify_user varchar(32) NULL DEFAULT NULL,
  modify_time timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE,
  UNIQUE INDEX sys_role101(role_code) USING BTREE,
  UNIQUE INDEX sys_role102(role_name) USING BTREE
)  COMMENT = '角色';

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  role_id bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  create_user varchar(32) NULL DEFAULT NULL,
  create_user_name varchar(32) NULL DEFAULT NULL,
  create_time timestamp(6) NULL DEFAULT NULL,
  modify_user varchar(32) NULL DEFAULT NULL,
  modify_time timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
)  COMMENT = '用户与角色对应关系';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  parent_id bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  name varchar(50) NULL DEFAULT NULL COMMENT '菜单名称',
  url varchar(200) NULL DEFAULT NULL COMMENT '菜单URL',
  perms varchar(500) NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  type int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  icon varchar(50) NULL DEFAULT NULL COMMENT '菜单图标',
  open_type int(1) NULL DEFAULT 0 COMMENT '打开方式，0：当前窗口打开，1：新窗口打开',
  order_num int(11) NULL DEFAULT NULL COMMENT '排序',
  create_user varchar(32) NULL DEFAULT NULL,
  create_user_name varchar(32) NULL DEFAULT NULL,
  create_time timestamp(6) NULL DEFAULT NULL,
  modify_user varchar(32) NULL DEFAULT NULL,
  modify_time timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
) COMMENT = '菜单管理';

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_id bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  menu_id bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  create_user varchar(32) NULL DEFAULT NULL,
  create_user_name varchar(32) NULL DEFAULT NULL,
  create_time timestamp(6) NULL DEFAULT NULL,
  modify_user varchar(32) NULL DEFAULT NULL,
  modify_time timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
) COMMENT = '角色与菜单对应关系';

DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept  (
  id bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  dept_code varchar(32) NULL DEFAULT NULL,
  dept_name varchar(50) NULL DEFAULT NULL COMMENT '部门名称',
  parent_id bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  order_num int(11) NULL DEFAULT NULL COMMENT '排序',
  del_flag int(4) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除  1：已删除  0：正常',
  create_user varchar(32) NULL DEFAULT NULL,
  create_user_name varchar(32) NULL DEFAULT NULL,
  create_time timestamp(6) NULL DEFAULT NULL,
  modify_user varchar(32) NULL DEFAULT NULL,
  modify_time timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (id) USING BTREE
)  COMMENT = '部门管理';

DROP TABLE IF EXISTS sys_config;
CREATE TABLE sys_config  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  param_key varchar(50) NULL DEFAULT NULL COMMENT 'key',
  param_value varchar(2000) NULL DEFAULT NULL COMMENT 'value',
  status tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  remark varchar(500) NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (id) USING BTREE,
  UNIQUE INDEX param_key(param_key) USING BTREE
) COMMENT = '系统配置信息表';

DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100)  NOT NULL COMMENT '字典名称',
  type varchar(100)  NOT NULL COMMENT '字典类型',
  code varchar(100)  NOT NULL COMMENT '字典码',
  value varchar(1000)  NOT NULL COMMENT '字典值',
  order_num int(11) NULL DEFAULT 0 COMMENT '排序',
  remark varchar(255)  NULL DEFAULT NULL COMMENT '备注',
  del_flag tinyint(4) NULL DEFAULT 0 COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (id) USING BTREE,
  UNIQUE INDEX type(type, code) USING BTREE
) COMMENT = '数据字典表';


DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(50) NULL DEFAULT NULL COMMENT '用户名',
  operation varchar(50) NULL DEFAULT NULL COMMENT '用户操作',
  method varchar(200) NULL DEFAULT NULL COMMENT '请求方法',
  params varchar(5000) NULL DEFAULT NULL COMMENT '请求参数',
  time bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  ip varchar(64) NULL DEFAULT NULL COMMENT 'IP地址',
  create_date timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (id) USING BTREE
) COMMENT = '系统日志';

DROP TABLE IF EXISTS sys_oss;
CREATE TABLE sys_oss  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  url varchar(200) NULL DEFAULT NULL COMMENT 'URL地址',
  create_date datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (id) USING BTREE
) COMMENT = '文件上传';

DROP TABLE IF EXISTS sys_role_dept;
CREATE TABLE sys_role_dept  (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_id bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  dept_id bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (id) USING BTREE
) COMMENT = '角色与部门对应关系';

--    -----------------  生产模块  --------------
--  合同表
DROP TABLE IF EXISTS pp_contract;
CREATE TABLE pp_contract (
  id bigint(64) NOT NULL AUTO_INCREMENT,
	contract_code varchar(64) NOT NULL  COMMENT '合同号',
	station_id int(5)  NULL DEFAULT NULL COMMENT '工作站ID',
	station_Name varchar(128)  NULL DEFAULT NULL COMMENT '工作站名称',
	project_name varchar(256) NULL DEFAULT NULL COMMENT '工程名称',
	customer_id     bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
	customer_name   varchar(128) NULL DEFAULT NULL COMMENT '客户名称',
	construction_unit varchar(256) NULL DEFAULT NULL COMMENT '施工单位',
	accounting_unit   varchar(256) NULL DEFAULT NULL COMMENT '核算单位',
	contract_type int(5)  NULL DEFAULT NULL COMMENT '合同类型',
	plan_date      date NULL DEFAULT NULL COMMENT '计划日期',
	plan_quantity        int(16) NULL DEFAULT NULL COMMENT '计划数量',
	max_amount  int(16) NULL DEFAULT NULL COMMENT '金额上限(元)',
	settlement_method  int(5) NULL DEFAULT NULL COMMENT '结算方式',
	contract_responsible_person varchar(20) NULL DEFAULT NULL COMMENT '合同负责人',
	construction_place  varchar(256) NULL DEFAULT NULL COMMENT '施工地点',
	sign_date date NULL DEFAULT NULL COMMENT '签订日期',
	delivery_date date null DEFAULT NULL COMMENT '供货日期',
	telephone varchar(20) NULL DEFAULT NULL COMMENT '联系电话',
	liaison_person varchar(20) NULL DEFAULT NULL COMMENT '联系人',
	pour_part varchar(256) NULL DEFAULT NULL COMMENT '浇筑部位',
	pour_method  varchar(64) NULL DEFAULT NULL COMMENT '浇筑方式',
	intensity_level varchar(20) NULL DEFAULT NULL COMMENT '强度等级C',
	impermeability_level   varchar(20) NULL DEFAULT NULL COMMENT '抗渗等级P',
	frost_resistance_level varchar(20) NULL DEFAULT NULL COMMENT '抗冻等级F',
	bend_level            varchar(20) NULL DEFAULT NULL COMMENT '抗折等级Z',
	anticorrosive_level  varchar(20) NULL DEFAULT NULL COMMENT '防腐等级P',
	technical_requirement   varchar(1024) NULL DEFAULT NULL COMMENT '技术要求',
	other_requirement varchar(1024) NULL DEFAULT NULL COMMENT '其他要求',
	slump     varchar(20) NULL DEFAULT NULL COMMENT '坍落度',
	concrete_quantity int(10) NULL DEFAULT NULL COMMENT '混凝土量(方)',
	part_sort  int(10) NULL DEFAULT NULL COMMENT '部位序号',
  product_spec varchar(128) NULL DEFAULT NULL COMMENT '产品规格',
	material_type int(10)  NULL DEFAULT NULL COMMENT '材料种类',
	stone_type int(10)  NULL DEFAULT NULL COMMENT '石子种类',
	sand_type  int(10)  NULL DEFAULT NULL COMMENT '砂子种类',
	stone_diameter  int(10)  NULL DEFAULT NULL COMMENT '石子粒径',
	cement_variety  int(10)  NULL DEFAULT NULL COMMENT '水泥品种',
  cement_lable  varchar(64)  NULL DEFAULT NULL COMMENT '水泥标号',
	status        int(2) NULL DEFAULT 0 COMMENT '状态，0:草稿，1：提交',
	create_user varchar(32)  NULL DEFAULT NULL COMMENT '创建人',
  create_user_name varchar(32)  NULL DEFAULT NULL COMMENT '创建人名称',
  create_time timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  modify_user varchar(32)  NULL DEFAULT NULL COMMENT '最后更新人',
  modify_time timestamp(6) NULL DEFAULT NULL COMMENT '最后更时间',
  PRIMARY KEY (id) USING BTREE,
  UNIQUE INDEX pp_project_001(contract_code) USING BTREE
) COMMENT = '合同信息';


--  工程表
DROP TABLE IF EXISTS pp_project;
CREATE TABLE pp_project  (
  id bigint(64) NOT NULL AUTO_INCREMENT,
	project_code varchar(64) NOT NULL  COMMENT '工程编号',
	project_name varchar(256) NULL DEFAULT NULL COMMENT '工程名称',
	contract_id bigint(64)  NULL DEFAULT NULL COMMENT '合同ID',
	contract_code varchar(64) NOT NULL  COMMENT '合同号',
	project_status int(5)  NULL DEFAULT NULL COMMENT '工程状态',
	project_category int(5) NULL DEFAULT NULL COMMENT '工程类别',
	project_county varchar(256)  NULL DEFAULT NULL COMMENT '工程区县',
	commencement_date Date NULL DEFAULT NULL COMMENT '开工日期',
	plan_period int(8)    NULL DEFAULT NULL COMMENT '计划工期(天)',
	investment_unit   varchar(256) NULL DEFAULT NULL COMMENT '投资单位',
	supervisors_unit    varchar(256) NULL DEFAULT NULL COMMENT '监理单位',
	transport_distance  int(10) NULL DEFAULT NULL COMMENT '运输距离',
	transport_cost      int(10) NULL DEFAULT NULL COMMENT '运送费用',
	legal_representative  varchar(50) NULL DEFAULT NULL COMMENT '法定代表人',
	supplier    varchar(64) NULL DEFAULT NULL COMMENT '混凝土供应企业',
	status        int(2) NULL DEFAULT NULL COMMENT '状态，0:草稿，1：提交',
	create_user varchar(32)  NULL DEFAULT NULL COMMENT '创建人',
  create_user_name varchar(32)  NULL DEFAULT NULL COMMENT '创建人名称',
  create_time timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  modify_user varchar(32)  NULL DEFAULT NULL COMMENT '最后更新人',
  modify_time timestamp(6) NULL DEFAULT NULL COMMENT '最后更时间',
  PRIMARY KEY (id) USING BTREE,
  UNIQUE INDEX pp_project_001(project_code) USING BTREE
) COMMENT = '工程信息';


DROP TABLE IF EXISTS pp_task;
CREATE TABLE pp_task  (
    id bigint(64) NOT NULL AUTO_INCREMENT,
    task_code varchar(64) NULL DEFAULT NULL COMMENT '任务编号',
	task_name varchar(50) NULL DEFAULT NULL COMMENT '任务单名称',
	order_id   bigint(20) NULL DEFAULT NULL COMMENT '顺序ID',
	project_id     bigint(64) NULL DEFAULT NULL COMMENT '工程ID',
	recipe_id      bigint(64) NULL DEFAULT NULL COMMENT '配比ID',
	employee_id    bigint(64) NULL DEFAULT NULL COMMENT '员工ID',
	employee_name    varchar(32) NULL DEFAULT NULL COMMENT '员工',
	project_core_info   varchar(256) NULL DEFAULT NULL COMMENT '工程核心信息',
	out_quantity    int NULL DEFAULT NULL COMMENT '超出数量',
	end_quantity    int NULL DEFAULT NULL COMMENT '结束数量',
	delivery_telephone  varchar(16) NULL DEFAULT NULL COMMENT '送货地址电话',
	status        int(2) NULL DEFAULT NULL COMMENT '状态',
	create_user varchar(32)  NULL DEFAULT NULL COMMENT '创建人',
  create_user_name varchar(32)  NULL DEFAULT NULL COMMENT '创建人名称',
  create_time timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  modify_user varchar(32)  NULL DEFAULT NULL COMMENT '最后更新人',
  modify_time timestamp(6) NULL DEFAULT NULL COMMENT '最后更时间',
  PRIMARY KEY (id) USING BTREE
) COMMENT = '生产任务单';

DROP TABLE IF EXISTS pp_recipe;
CREATE TABLE pp_recipe(
    id bigint(64) NOT NULL AUTO_INCREMENT COMMENT 'id',
    recipe_code varchar(64) NOT NULL COMMENT '配比编码',
    recipe_name varchar(50) NULL DEFAULT NULL COMMENT '配比名称',
	intensity_level varchar(20) NULL DEFAULT NULL COMMENT '强度等级C',
	water_binder_ratio     varchar(20) NULL DEFAULT NULL COMMENT '水胶比',
	sand_rate   		varchar(20) NULL DEFAULT NULL COMMENT '砂率',
	slump     varchar(20) NULL DEFAULT NULL COMMENT '坍落度',
	cement1     varchar(20) NULL DEFAULT NULL COMMENT '水泥1',
	cement2     varchar(20) NULL DEFAULT NULL COMMENT '水泥2',
	cement3    varchar(20) NULL DEFAULT NULL COMMENT '水泥3',
	sand1      varchar(20) NULL DEFAULT NULL COMMENT '砂子1',
	sand2     varchar(20) NULL DEFAULT NULL COMMENT '砂子2',
	sand3     varchar(20) NULL DEFAULT NULL COMMENT '砂子31',
	big_stone      varchar(20) NULL DEFAULT NULL COMMENT '大石量',
	middle_stone      varchar(20) NULL DEFAULT NULL COMMENT '中石量',
	small_stone      varchar(20) NULL DEFAULT NULL COMMENT '小石量',
	flyash      varchar(20) NULL DEFAULT NULL COMMENT '粉煤灰',
	mine_powder       varchar(20) NULL DEFAULT NULL COMMENT '矿粉',
	additive1     varchar(20) NULL DEFAULT NULL COMMENT '外加剂1',
	additive2     varchar(20) NULL DEFAULT NULL COMMENT '外加剂2',
	additive3      varchar(20) NULL DEFAULT NULL COMMENT '外加剂3',
	additive4      varchar(20) NULL DEFAULT NULL COMMENT '外加剂4',
    water 		 varchar(20) NULL DEFAULT NULL COMMENT '水',
    other1     varchar(20) NULL DEFAULT NULL COMMENT '其他1',
    other2 		 varchar(20)  NULL DEFAULT NULL COMMENT '其他2',
    impermeability_level   varchar(20) NULL DEFAULT NULL COMMENT '抗渗等级P',
	bend_level            varchar(20) NULL DEFAULT NULL COMMENT '抗折等级F',
	sand_level            int(20) NULL DEFAULT NULL COMMENT '砂等级',
	stone_diameter_max         varchar(20) NULL DEFAULT NULL COMMENT '石子最大粒径',
	apparent_density           varchar(20) NULL DEFAULT NULL COMMENT '表观密度',
	status        int(2) NULL DEFAULT 0 COMMENT '状态，0:草稿，1：提交',
	create_user varchar(32)  NULL DEFAULT NULL COMMENT '创建人',
    create_user_name varchar(32)  NULL DEFAULT NULL COMMENT '创建人名称',
    create_time timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
    modify_user varchar(32)  NULL DEFAULT NULL COMMENT '最后更新人',
    modify_time timestamp(6) NULL DEFAULT NULL COMMENT '最后更时间',
    PRIMARY KEY (id) USING BTREE
) COMMENT = '配比单';