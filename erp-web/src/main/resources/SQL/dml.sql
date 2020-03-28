/*初始用户，系统管理员*/
INSERT INTO sys_user VALUES (1, 'admin', '系统管理员', '$2a$10$v8UUl3q3qTicUyMoPW/XIu8yeU7GnnbvAgqhFVGxjQU36flc16TuW', 'www', 0, NULL, NULL, 0, 1, NULL, NULL, NULL, NULL, 'admin', '2019-09-22 13:42:26');
/*菜单数据*/
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 0,0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (2, 1, '用户管理', 'view/sys/user.html', NULL, 1, 'fa fa-user',0, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (31, 1, '部门管理', 'view/sys/dept.html', NULL, 1, 'fa fa-file-code-o', 0,1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (3, 1, '角色管理', 'view/sys/role.html', NULL, 1, 'fa fa-user-secret',0, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (4, 1, '菜单管理', 'view/sys/menu.html', NULL, 1, 'fa fa-th-list', 0,3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu(id,parent_id,name,url,perms,type,icon,open_type,order_num,create_user,create_user_name,create_time,modify_user,modify_time)
VALUES (5, 1, 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug',0, 4, NULL, NULL, NULL, NULL, NULL);
