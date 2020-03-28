--   ------------三一重工搅拌站用到的表 --------------------
DROP TABLE IF EXISTS task;
CREATE TABLE task  (
  TaskID bigint(64) NOT NULL,
  TaskName varchar(50)  NULL DEFAULT NULL COMMENT '任务单名称',
  StationID bigint(20) NULL DEFAULT NULL COMMENT '站点ID',
  OrderID bigint(20) NULL DEFAULT NULL COMMENT '顺序ID',
  ItemID bigint(20) NULL DEFAULT NULL COMMENT '生产ID',
  EmployeeID bigint(20) NULL DEFAULT NULL COMMENT '员工ID',
  planDate timestamp(6) NULL DEFAULT NULL COMMENT '计划时间',
  ShipToAdd1 varchar(16)  NULL DEFAULT NULL COMMENT '送货地址电话',
  OutCount int(11) NULL DEFAULT NULL COMMENT '超出数量',
  PlanCount int(11) NULL DEFAULT NULL COMMENT '计划数量',
  EndCount int(11) NULL DEFAULT NULL COMMENT '结束数量',
  CustomerID bigint(64) NULL DEFAULT NULL COMMENT '客户ID',
  ProjectName varchar(256)  NULL DEFAULT NULL COMMENT '工程名称',
  ProjectCmpy varchar(256)  NULL DEFAULT NULL COMMENT '工程核心信息',
  RecipeNo bigint(64) NULL DEFAULT NULL COMMENT '配比ID',
  ProjectPart varchar(256)  NULL DEFAULT NULL COMMENT '工程部位',
  WorkMethod varchar(64)  NULL DEFAULT NULL COMMENT '浇筑方式',
  Distance int(11) NULL DEFAULT NULL COMMENT '运输距离',
  CustomerName varchar(128)  NULL DEFAULT NULL COMMENT '客户名称',
  Ustate varchar(10)  NULL DEFAULT NULL COMMENT '状态',

  PRIMARY KEY (TaskID) USING BTREE
)  COMMENT = '生产任务单';

DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe(
    RecipeID bigint(64) NOT NULL AUTO_INCREMENT COMMENT '配比编码',
    RecipeName varchar(50) NULL DEFAULT NULL COMMENT '配比名称',
	intensityLevel varchar(20) NULL DEFAULT NULL COMMENT '强度等级',
	sjb     varchar(20) NULL DEFAULT NULL COMMENT '水胶比',
	sl   		varchar(20) NULL DEFAULT NULL COMMENT '砂率',
	tld     varchar(20) NULL DEFAULT NULL COMMENT '坍落度',
	RecipeSN1     varchar(20) NULL DEFAULT NULL COMMENT '水泥1',
	RecipeSN2     varchar(20) NULL DEFAULT NULL COMMENT '水泥2',
	RecipeSN3     varchar(20) NULL DEFAULT NULL COMMENT '水泥3',
	RecipeSZ      varchar(20) NULL DEFAULT NULL COMMENT '砂子1',
	RecipeXSL     varchar(20) NULL DEFAULT NULL COMMENT '砂子2',
	RecipeSZ1     varchar(20) NULL DEFAULT NULL COMMENT '砂子31',
	RecipeDSL      varchar(20) NULL DEFAULT NULL COMMENT '大石量',
	RecipeZSL      varchar(20) NULL DEFAULT NULL COMMENT '中石量',
	RecipeSZ2      varchar(20) NULL DEFAULT NULL COMMENT '小石量',
	RecipeFMH      varchar(20) NULL DEFAULT NULL COMMENT '粉煤灰',
	RecipeKF       varchar(20) NULL DEFAULT NULL COMMENT '矿粉',
	RecipeWJJ1     varchar(20) NULL DEFAULT NULL COMMENT '外加剂1',
	RecipeWJJ2     varchar(20) NULL DEFAULT NULL COMMENT '外加剂2',
	RecipeSN4      varchar(20) NULL DEFAULT NULL COMMENT '外加剂3',
	RecipeFJJ      varchar(20) NULL DEFAULT NULL COMMENT '外加剂4',
    RecipeSHUI 		 varchar(20) NULL DEFAULT NULL COMMENT '水',
    RecipeOth1     varchar(20) NULL DEFAULT NULL COMMENT '其他1',
    RecipeOth2 		 varchar(20)  NULL DEFAULT NULL COMMENT '其他2',
    ksd            varchar(20) NULL DEFAULT NULL COMMENT '抗渗等级',
	kzd            varchar(20) NULL DEFAULT NULL COMMENT '抗折等级',
	sljdj          varchar(20) NULL DEFAULT NULL COMMENT '砂等级',
	sszdlj         varchar(20) NULL DEFAULT NULL COMMENT '石子最大粒径',
	bgmd           varchar(20) NULL DEFAULT NULL COMMENT '表观密度',

  PRIMARY KEY (RecipeID) USING BTREE
) COMMENT = '配比单';