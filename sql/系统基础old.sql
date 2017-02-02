/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2016/7/24 16:31:39                           */
/*==============================================================*/


DROP TABLE BASE_DEPT CASCADE CONSTRAINTS;

DROP TABLE BASE_OPERATION CASCADE CONSTRAINTS;

DROP TABLE BASE_ROLE CASCADE CONSTRAINTS;

DROP TABLE BASE_USER_DEPT CASCADE CONSTRAINTS;

DROP TABLE BASE_USER_GROUP_ROLE CASCADE CONSTRAINTS;

DROP TABLE BSE_ROLE_OPERATION CASCADE CONSTRAINTS;

DROP TABLE DICT_ENTITY CASCADE CONSTRAINTS;

DROP TABLE DICT_TYPE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: BASE_DEPT                                             */
/*==============================================================*/
CREATE TABLE BASE_DEPT  (
   ID                   VARCHAR2(50)                    NOT NULL,
   DEPT_NAME            VARCHAR2(50),
   SUPER_ID             VARCHAR2(50),
   STATUS               VARCHAR2(50),
   CRE_DATE             VARCHAR2(50),
   DEPT_CODE            VARCHAR2(50),
   ORDER_NO             VARCHAR2(50),
   DEPT_ABBR            VARCHAR2(50),
   DEPT_LEVEL           VARCHAR2(20),
   CONSTRAINT PK_BASE_DEPT PRIMARY KEY (ID)
);

COMMENT ON TABLE BASE_DEPT IS
'部门表';

COMMENT ON COLUMN BASE_DEPT.ID IS
'主键';

COMMENT ON COLUMN BASE_DEPT.DEPT_NAME IS
'部门名称';

COMMENT ON COLUMN BASE_DEPT.SUPER_ID IS
'上级部门';

COMMENT ON COLUMN BASE_DEPT.STATUS IS
'状态';

COMMENT ON COLUMN BASE_DEPT.CRE_DATE IS
'创建时间';

COMMENT ON COLUMN BASE_DEPT.DEPT_CODE IS
'部门编号';

COMMENT ON COLUMN BASE_DEPT.ORDER_NO IS
'排序';

COMMENT ON COLUMN BASE_DEPT.DEPT_ABBR IS
'部门简称';

COMMENT ON COLUMN BASE_DEPT.DEPT_LEVEL IS
'部门等级';

/*==============================================================*/
/* Table: BASE_OPERATION                                        */
/*==============================================================*/
CREATE TABLE BASE_OPERATION  (
   ID                   VARCHAR2(50)                    NOT NULL,
   RESOURCES_NAME       VARCHAR2(100),
   PARENT_ID            VARCHAR2(50),
   MEMO                 VARCHAR2(500),
   ICON                 BLOB,
   "COMMENT"            VARCHAR2(2000),
   URL                  VARCHAR2(4000),
   Z_STATUS             VARCHAR2(2),
   CONSTRAINT PK_BASE_OPERATION PRIMARY KEY (ID)
);

COMMENT ON TABLE BASE_OPERATION IS
'包含菜单';

COMMENT ON COLUMN BASE_OPERATION.ID IS
'主键';

COMMENT ON COLUMN BASE_OPERATION.RESOURCES_NAME IS
'名称';

COMMENT ON COLUMN BASE_OPERATION.PARENT_ID IS
'父id';

COMMENT ON COLUMN BASE_OPERATION.MEMO IS
'描述';

COMMENT ON COLUMN BASE_OPERATION.ICON IS
'图标';

COMMENT ON COLUMN BASE_OPERATION."COMMENT" IS
'说明';

COMMENT ON COLUMN BASE_OPERATION.URL IS
'路径';

COMMENT ON COLUMN BASE_OPERATION.Z_STATUS IS
'状态';

/*==============================================================*/
/* Table: BASE_ROLE                                             */
/*==============================================================*/
CREATE TABLE BASE_ROLE  (
   ID                   VARCHAR2(50)                    NOT NULL,
   ROLE_NAME            VARCHAR2(50),
   STATUS               VARCHAR2(2),
   CRE_DATE             DATE,
   CRE_USER             VARCHAR2(50),
   CRE_DEPT             VARCHAR2(50),
   CONSTRAINT PK_BASE_ROLE PRIMARY KEY (ID)
);

COMMENT ON COLUMN BASE_ROLE.ID IS
'主键';

COMMENT ON COLUMN BASE_ROLE.ROLE_NAME IS
'角色名';

COMMENT ON COLUMN BASE_ROLE.STATUS IS
'状态';

COMMENT ON COLUMN BASE_ROLE.CRE_DATE IS
'创建时间';

COMMENT ON COLUMN BASE_ROLE.CRE_USER IS
'创建人';

COMMENT ON COLUMN BASE_ROLE.CRE_DEPT IS
'创建部门';

/*==============================================================*/
/* Table: BASE_USER_DEPT                                        */
/*==============================================================*/
CREATE TABLE BASE_USER_DEPT  (
   ID                   VARCHAR2(50)                    NOT NULL,
   USER_ID              VARCHAR2(50),
   DEPT_ID              VARCHAR2(50),
   CONSTRAINT PK_BASE_USER_DEPT PRIMARY KEY (ID)
);

COMMENT ON COLUMN BASE_USER_DEPT.ID IS
'主键';

COMMENT ON COLUMN BASE_USER_DEPT.USER_ID IS
'用户id';

COMMENT ON COLUMN BASE_USER_DEPT.DEPT_ID IS
'部门id';

/*==============================================================*/
/* Table: BASE_USER_GROUP_ROLE                                  */
/*==============================================================*/
CREATE TABLE BASE_USER_GROUP_ROLE  (
   ID                   VARCHAR2(50)                    NOT NULL,
   USER_ID              VARCHAR2(50),
   ROLE_ID              VARCHAR2(50),
   Z_STATUS             VARCHAR2(2),
   CONSTRAINT PK_BASE_USER_GROUP_ROLE PRIMARY KEY (ID)
);

COMMENT ON COLUMN BASE_USER_GROUP_ROLE.ID IS
'主键';

COMMENT ON COLUMN BASE_USER_GROUP_ROLE.USER_ID IS
'用户组id';

COMMENT ON COLUMN BASE_USER_GROUP_ROLE.ROLE_ID IS
'角色id';

COMMENT ON COLUMN BASE_USER_GROUP_ROLE.Z_STATUS IS
'状态';

/*==============================================================*/
/* Table: BSE_ROLE_OPERATION                                    */
/*==============================================================*/
CREATE TABLE BSE_ROLE_OPERATION  (
   ID                   VARCHAR2(50)                    NOT NULL,
   ROLE_ID              VARCHAR2(50),
   OPERATION_ID         VARCHAR2(50),
   CONSTRAINT PK_BSE_ROLE_OPERATION PRIMARY KEY (ID)
);

COMMENT ON COLUMN BSE_ROLE_OPERATION.ID IS
'主键';

COMMENT ON COLUMN BSE_ROLE_OPERATION.ROLE_ID IS
'角色id';

COMMENT ON COLUMN BSE_ROLE_OPERATION.OPERATION_ID IS
'操作id';

/*==============================================================*/
/* Table: DICT_ENTITY                                           */
/*==============================================================*/
CREATE TABLE DICT_ENTITY  (
   ID                   VARCHAR2(50)                    NOT NULL,
   DICT_NAME            VARCHAR2(200),
   DICT_TYPE_ID         VARCHAR2(50),
   Z_STATUS             VARCHAR2(2),
   CONSTRAINT PK_DICT_ENTITY PRIMARY KEY (ID)
);

COMMENT ON COLUMN DICT_ENTITY.ID IS
'主键';

COMMENT ON COLUMN DICT_ENTITY.DICT_NAME IS
'名称';

COMMENT ON COLUMN DICT_ENTITY.DICT_TYPE_ID IS
'类型id';

COMMENT ON COLUMN DICT_ENTITY.Z_STATUS IS
'状态';

/*==============================================================*/
/* Table: DICT_TYPE                                             */
/*==============================================================*/
CREATE TABLE DICT_TYPE  (
   ID                   NUMBER(50)                      NOT NULL,
   TYPE_NAME            VARCHAR2(100),
   STATUS               CHAR2(1),
   CONSTRAINT PK_DICT_TYPE PRIMARY KEY (ID)
);

COMMENT ON COLUMN DICT_TYPE.ID IS
'主键';

COMMENT ON COLUMN DICT_TYPE.TYPE_NAME IS
'类型名称';

COMMENT ON COLUMN DICT_TYPE.STATUS IS
'状态';

