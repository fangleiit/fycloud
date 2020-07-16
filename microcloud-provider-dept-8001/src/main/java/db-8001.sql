DROP DATABASE IF EXISTS mldn8001;
CREATE DATABASE mld8001 CHARACTER SET UTF8;
USE mldn8001;
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