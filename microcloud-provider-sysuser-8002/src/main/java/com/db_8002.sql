--USE mldn8001;
--用户表
CREATE TABLE sys_user(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    username VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(50) NOT NULL COMMENT '密码',
    email VARCHAR(100) COMMENT '邮箱',
    date_birth DATE COMMENT '出生日期',
    age TINYINT(100) COMMENT '年龄(1:男;2:女)',
    sex CHAR(1) NOT NULL COMMENT '性别',
    realname VARCHAR(50) COMMENT '真实姓名',
    home_address VARCHAR(255) COMMENT '家庭住址',
    current_address VARCHAR(255) COMMENT '当前住址',
    phone_number VARCHAR(50) COMMENT '手机号',
    corporate_name VARCHAR(100) COMMENT '公司名称',
    dept_id BIGINT NOT NULL COMMENT '部门ID',
    position_job VARCHAR(100) COMMENT '职位',
    positional_titles VARCHAR(100) COMMENT '职称',
    record_schooling VARCHAR(100) COMMENT '学历',
    document_type VARCHAR(20) COMMENT '证件类型',
    id_number VARCHAR(100) COMMENT '证件号码',
    marital_status CHAR(1) COMMENT '婚姻状况(1:已婚;2:未婚)',
    user_mode CHAR(4) COMMENT '用户状态(001:启用;002:停用)',
    CONSTRAINT pk_id PRIMARY KEY(id)
) COMMENT = '用户表';
--添加字段
ALTER TABLE sys_user ADD COLUMN create_time DATETIME NOT NULL COMMENT '创建时间' AFTER marital_status;
ALTER TABLE sys_user ADD COLUMN create_by VARCHAR(100) NOT NULL COMMENT '创建人' AFTER create_time;
ALTER TABLE sys_user ADD COLUMN update_time DATETIME  NULL COMMENT '修改时间' AFTER create_by;
ALTER TABLE sys_user ADD COLUMN update_by VARCHAR(100)  NULL COMMENT '修改人' AFTER update_time;

--创建数据
INSERT INTO sys_user(username,`password`,email,date_birth,age,sex,realname,home_address,
current_address,phone_number,corporate_name,dept_id,position_job,positional_titles,record_schooling,
document_type,id_number,marital_status,user_mode,create_time,create_by)
VALUES ('admin','123456','854016108@qq.com',STR_TO_DATE('05.03.1990', '%m.%d.%Y'),30,'1','管理员','河南省洛阳市',
'河南省郑州市南阳路151号院','15238679100','上海方优信息技术有限公司','16','主数据管理员','主数据管理','本科',
'SFZ','410329199004259900','2','001',NOW(),'admin');

INSERT INTO sys_user(username,`password`,email,date_birth,age,sex,realname,home_address,
current_address,phone_number,corporate_name,dept_id,position_job,positional_titles,record_schooling,
document_type,id_number,marital_status,user_mode,create_time,create_by)
VALUES ('fangyou','123456','11865622@qq.com',STR_TO_DATE('04.15.1990', '%m.%d.%Y'),30,'1','方磊','河南省洛阳市',
'河南省郑州市南阳路151号院','15238679800','上海方优信息技术有限公司','16','主数据管理员','主数据管理','本科',
'SFZ','410329199005259900','2','001',NOW(),'admin');

INSERT INTO sys_user(username,`password`,email,date_birth,age,sex,realname,home_address,
current_address,phone_number,corporate_name,dept_id,position_job,positional_titles,record_schooling,
document_type,id_number,marital_status,user_mode,create_time,create_by)
VALUES ('lily','123456','1186555@qq.com',STR_TO_DATE('04.15.2000', '%m.%d.%Y'),20,'2','李莉','陕西省西安市莲湖区北关正街150号',
'河南省郑州市惠济区天河路151号','15236889118','上海方优信息技术有限公司','18','招聘主管','高级企业人力资源管理师','本科',
'XSZ','47130010092022','2','001',NOW(),'admin');

