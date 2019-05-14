INSERT INTO system_property_domain(id, domain_name) VALUES (8, '任务类型');
INSERT INTO system_property_domain(id, domain_name) VALUES (9, '人源类型');


INSERT INTO system_property_dict(id, property_domain_id, display_name) VALUES (30, 8, 'java方法');
INSERT INTO system_property_dict(id, property_domain_id, display_name) VALUES (31, 8, 'sql语句');
INSERT INTO system_property_dict(id, property_domain_id, display_name) VALUES (32, 9, '主管');
INSERT INTO system_property_dict(id, property_domain_id, display_name) VALUES (32, 9, '员工');

INSERT INTO system_take_ploy(id, cname, ename, type, description, code) VALUES
(31, '测试定时任务', 'testQuartz', (select id from system_property_dict where display_name = 'java方法'), 'taskContectScheduler.addTaskContect', 'taskContectScheduler.addTaskContect');
INSERT INTO system_take(id, name, task_group, description, ploy_id, config, closed) VALUES
(30, 'testQuartz', 'testQuartz', 'testQuartz', (select id from system_take_ploy where cname = '测试定时任务'), '0/10 * * * * ?', 1);