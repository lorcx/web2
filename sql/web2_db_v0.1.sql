/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2017/1/16 23:52:24                           */
/*==============================================================*/


DROP TABLE SYS_CONFIG CASCADE CONSTRAINTS;

DROP TABLE SYS_MENU CASCADE CONSTRAINTS;

DROP TABLE SYS_ROLE CASCADE CONSTRAINTS;

DROP TABLE SYS_ROLE_MENU CASCADE CONSTRAINTS;

DROP TABLE SYS_USER CASCADE CONSTRAINTS;

DROP TABLE SYS_USER_ROLE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: SYS_CONFIG                                            */
/*==============================================================*/
CREATE TABLE SYS_CONFIG 
(
   ID                   VARCHAR2(50)         NOT NULL,
   KEY                  VARCHAR2(50),
   VALUE                VARCHAR2(4000),
   REMARK               VARCHAR2(4000),
   STATUS                VARCHAR2(10),
   CONSTRAINT PK_SYS_CONFIG PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
CREATE TABLE SYS_MENU 
(
   ID                   VARCHAR2(50)         NOT NULL,
   MENU_NAME            VARCHAR2(150),
   ICON                 VARCHAR2(100),
   URL                  VARCHAR2(4000),
   PERMS                VARCHAR2(4000),
   ORDER_NUM            VARCHAR2(5),
   MENU_TYPE            VARCHAR2(10),
   PARENT_ID            VARCHAR2(50),
   CONSTRAINT PK_SYS_MENU PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
CREATE TABLE SYS_ROLE 
(
   ID                   VARCHAR2(50)         NOT NULL,
   ROLE_NAME            VARCHAR2(200),
   CRE_TIME             DATE,
   STATUS               VARCHAR2(5),
   REMARK               VARCHAR2(2000),
   CONSTRAINT PK_SYS_ROLE PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE_MENU                                         */
/*==============================================================*/
CREATE TABLE SYS_ROLE_MENU 
(
   ID                   VARCHAR2(50)         NOT NULL,
   MENU_ID              VARCHAR2(50),
   ROLE_ID              VARCHAR2(50),
   CONSTRAINT PK_SYS_ROLE_MENU PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
CREATE TABLE SYS_USER 
(
   ID                   VARCHAR2(50)         NOT NULL,
   USER_NAME            VARCHAR2(200),
   NICK_NAME            VARCHAR2(500),
   PASS_WORD            VARCHAR2(100),
   EMAIL                VARCHAR2(300),
   PHONE                VARCHAR2(40),
   STATUS               VARCHAR2(5),
   CRE_TIME             DATE,
   CONSTRAINT PK_SYS_USER PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
CREATE TABLE SYS_USER_ROLE 
(
   ID                   VARCHAR2(50)         NOT NULL,
   USER_ID              VARCHAR2(50),
   ROLE_ID              VARCHAR2(50),
   CONSTRAINT PK_SYS_USER_ROLE PRIMARY KEY (ID)
);

