--部门表
--CREATE DATABASE mld8001 CHARACTER SET UTF8;
--USE mldn8001;
CREATE TABLE dept(
    deptno BIGINT AUTO_INCREMENT,
    dname VARCHAR(50),
    loc VARCHAR(50),
    CONSTRAINT pk_deptno PRIMARY KEY(deptno)
);
INSERT INTO dept(dname,loc) VALUES ('研发部',DATABASE());
INSERT INTO dept(dname,loc) VALUES ('财务部',DATABASE());
INSERT INTO dept(dname,loc) VALUES ('市场部',DATABASE());
INSERT INTO dept(dname,loc) VALUES ('后勤部',DATABASE());
INSERT INTO dept(dname,loc) VALUES ('公关部',DATABASE());
--数据字典
CREATE TABLE sys_sjzd(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    zdbh VARCHAR(100) NOT NULL COMMENT '字典编号',
    zddm VARCHAR(100) NOT NULL COMMENT '字典代码',
    zddmmc VARCHAR(255) NOT NULL COMMENT '代码名称',
    zddmz VARCHAR(255) NOT NULL COMMENT '字典名称',
    zd_status CHAR(3) NOT NULL COMMENT '数据状态(001:启用;002:停用)',
    CONSTRAINT pk_id PRIMARY KEY(id)
) COMMENT = '字典表';
INSERT INTO sys_sjzd(zdbh,zddm,zddmz,zddmmc,zd_status) VALUES ('CARDTYPE','1','SFZ','身份证','001');
INSERT INTO sys_sjzd(zdbh,zddm,zddmz,zddmmc,zd_status) VALUES ('CARDTYPE','2','JSZ','驾驶证','001');
INSERT INTO sys_sjzd(zdbh,zddm,zddmz,zddmmc,zd_status) VALUES ('CARDTYPE','3','SBK','社保卡','001');
INSERT INTO sys_sjzd(zdbh,zddm,zddmz,zddmmc,zd_status) VALUES ('CARDTYPE','4','JZZ','居住证','001');
INSERT INTO sys_sjzd(zdbh,zddm,zddmz,zddmmc,zd_status) VALUES ('CARDTYPE','5','XSZ','学生证','001');
