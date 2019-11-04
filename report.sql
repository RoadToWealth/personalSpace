
 DROP TABLE IF EXISTS `SYS_LOGS`;  
 CREATE TABLE `SYS_LOGS`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `HTTP_URL`  varchar(50) comment '请求地址', 
 `HTTP_METHOD`  varchar(50) comment '请求方式', 
 `IP`  varchar(50) comment 'ip地址', 
 `PARAMS`  varchar(50) comment '请求参数', 
 `CLASS_METHOD`  varchar(50) comment '请求方法', 
 `CREATE_DATE`  date comment '创建时间', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;


 DROP TABLE IF EXISTS `SYS_PERMISSION`;  
 CREATE TABLE `SYS_PERMISSION`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `NAME`  varchar(50) comment '资源名称', 
 `TYPE`  varchar(50) comment '资源类型：menu,button,', 
 `URL`  varchar(50) comment '访问url地址', 
 `PERCODE`  varchar(50) comment '权限代码字符串', 
 `ICON`  varchar(50) comment '图标', 
 `PARENTID`  int comment '父结点id', 
 `SORTSTRING`  varchar(50) comment '排序号', 
 `AVAILABLE`  varchar(50) comment '是否可用,0：可用，1不可用', 
 `VIEW_FLAG`  varchar(50) comment '是否展示,0：展示，1不展示', 
 `CREATE_DATE`  date comment '创建时间', 
 `IS_SORTSTRING`  varchar(50) comment '是否按照序列号排序查询', 
 `FUNC_LIST`  varchar(50) comment '', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;


 DROP TABLE IF EXISTS `SYS_ROLE`;  
 CREATE TABLE `SYS_ROLE`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `NAME`  varchar(50) comment '角色名称', 
 `REMARK`  varchar(50) comment '角色描述', 
 `AVAILABLE`  varchar(50) comment '是否可用,0：可用，1不可用', 
 `CREATE_DATE`  date comment '创建时间', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;


 DROP TABLE IF EXISTS `SYS_ROLE_PERMISSION`;  
 CREATE TABLE `SYS_ROLE_PERMISSION`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `SYS_ROLE_ID`  int comment '角色ID', 
 `SYS_PERMISSION_ID`  int comment '权限ID', 
 `CREATE_DATE`  date comment '创建时间', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;


 DROP TABLE IF EXISTS `SYS_USER`;  
 CREATE TABLE `SYS_USER`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `USER_NAME`  varchar(50) comment '用户姓名', 
 `USER_CODE`  varchar(50) comment '登录名', 
 `PASSWORD`  varchar(50) comment '登录密码', 
 `SALT`  varchar(50) comment '密码加盐', 
 `GENDER`  int comment '性别', 
 `EMAIL`  varchar(50) comment '邮箱', 
 `PHONE`  varchar(50) comment '电话', 
 `ADDRESS`  varchar(50) comment '地址', 
 `NOTE`  varchar(50) comment '备注', 
 `LOCKED`  int comment '账号是否锁定，1：锁定，0未锁定', 
 `LAST_LOGIN_DATE`  date comment '最后一次登录时间', 
 `LOGIN_COUNT`  varchar(50) comment '登录次数', 
 `IS_DELETED`  int comment '是否删除 0 正常 1删除', 
 `CREATE_DATE`  date comment '创建时间', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;


 DROP TABLE IF EXISTS `SYS_USER_ROLE`;  
 CREATE TABLE `SYS_USER_ROLE`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `SYS_USER_ID`  int comment '用户ID', 
 `SYS_ROLE_ID`  int comment '角色ID', 
 `CREATE_DATE`  date comment '创建时间', 
 `SERIAL_VERSION_U_I_D`  varchar(50) comment 'null', 
 PRIMARY KEY (`id`) 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

