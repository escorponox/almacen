--------------------------------------------------------
--  DDL for Sequence CLIENTS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "CLIENTS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence CONTAINER_SEQ
--------------------------------------------------------

CREATE SEQUENCE "CONTAINER_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence INCOMING_DOCKS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "INCOMING_DOCKS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ITEM_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ITEM_SEQ" MINVALUE 100000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 100000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence LOCATE_ACTIONS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "LOCATE_ACTIONS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence LOCATIONS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "LOCATIONS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ORDERS_LINES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ORDERS_LINES_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ORDERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ORDERS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence OUTGOING_DOCKS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "OUTGOING_DOCKS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence PICKING_ACTIONS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "PICKING_ACTIONS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence PROVIDERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "PROVIDERS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence RECEIPT_ACTIONS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "RECEIPT_ACTIONS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence RECEIVING_ORDERS_LINES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "RECEIVING_ORDERS_LINES_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence RECEIVING_ORDERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "RECEIVING_ORDERS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USERS_SEQ" MINVALUE 1000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence USER_ROLES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USER_ROLES_SEQ" MINVALUE 1000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Table ACTION_STATUS
--------------------------------------------------------

CREATE TABLE "ACTION_STATUS"
(
  "ID"          NUMBER,
  "STATUS"      VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE)
);
--------------------------------------------------------
--  DDL for Table CLIENTS
--------------------------------------------------------

CREATE TABLE "CLIENTS"
(
  "ID"           NUMBER,
  "NIF"          VARCHAR2(9 BYTE),
  "NAME"         VARCHAR2(100 BYTE),
  "ADDRESS"      VARCHAR2(200 BYTE),
  "DEFAULT_DOCK" NUMBER
);
--------------------------------------------------------
--  DDL for Table CONTAINER
--------------------------------------------------------

CREATE TABLE "CONTAINER"
(
  "ID"       NUMBER,
  "ORDER_ID" NUMBER,
  "STATUS"   NUMBER,
  "OUT_DOCK" NUMBER
);
--------------------------------------------------------
--  DDL for Table CONTAINER_STATUS
--------------------------------------------------------

CREATE TABLE "CONTAINER_STATUS"
(
  "ID"          NUMBER,
  "STATUS"      VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE)
);
--------------------------------------------------------
--  DDL for Table DB_VERSION
--------------------------------------------------------

CREATE TABLE "DB_VERSION"
(
  "VERSION" VARCHAR2(20 BYTE)
);
--------------------------------------------------------
--  DDL for Table INCOMING_DOCKS
--------------------------------------------------------

CREATE TABLE "INCOMING_DOCKS"
(
  "ID"   NUMBER,
  "NAME" VARCHAR2(20 BYTE)
);
--------------------------------------------------------
--  DDL for Table ITEM
--------------------------------------------------------

CREATE TABLE "ITEM"
(
  "ID"          NUMBER,
  "CODE"        VARCHAR2(20 BYTE),
  "NAME"        VARCHAR2(40 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE),
  "LOCATION"    NUMBER,
  "PRICE"       NUMBER(*, 2)
);
--------------------------------------------------------
--  DDL for Table LOCATE_ACTIONS
--------------------------------------------------------

CREATE TABLE "LOCATE_ACTIONS"
(
  "ID"                NUMBER,
  "RECEIPT_ACTION_ID" NUMBER,
  "STATUS"            NUMBER,
  "PICKER_ID"         NUMBER
);
--------------------------------------------------------
--  DDL for Table LOCATIONS
--------------------------------------------------------

CREATE TABLE "LOCATIONS"
(
  "ID"       NUMBER,
  "CORRIDOR" VARCHAR2(3 BYTE),
  "SIDE"     VARCHAR2(1 BYTE),
  "MODULE"   VARCHAR2(3 BYTE),
  "NAME"     VARCHAR2(20 BYTE),
  "SEQ"      NUMBER
);
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

CREATE TABLE "ORDERS"
(
  "ID"         NUMBER,
  "CODE"       NUMBER,
  "SELLER_ID"  NUMBER,
  "CLIENT_ID"  NUMBER,
  "STATUS"     NUMBER,
  "CREATED_AT" DATE,
  "UPDATED_AT" DATE
);
--------------------------------------------------------
--  DDL for Table ORDERS_LINES
--------------------------------------------------------

CREATE TABLE "ORDERS_LINES"
(
  "ID"               NUMBER,
  "ORDER_ID"         NUMBER,
  "LINE_NUMBER"      NUMBER,
  "ITEM_ID"          NUMBER,
  "ORDERED_QUANTITY" NUMBER,
  "PENDING_QUANTITY" NUMBER
);
--------------------------------------------------------
--  DDL for Table ORDERS_STATUS
--------------------------------------------------------

CREATE TABLE "ORDERS_STATUS"
(
  "ID"          NUMBER,
  "STATUS"      VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE)
);
--------------------------------------------------------
--  DDL for Table OUTGOING_DOCKS
--------------------------------------------------------

CREATE TABLE "OUTGOING_DOCKS"
(
  "ID"   NUMBER,
  "NAME" VARCHAR2(20 BYTE)
);
--------------------------------------------------------
--  DDL for Table PICKING_ACTIONS
--------------------------------------------------------

CREATE TABLE "PICKING_ACTIONS"
(
  "ID"           NUMBER,
  "ORDER_ID"     NUMBER,
  "LINE_ID"      NUMBER,
  "CONTAINER_ID" NUMBER,
  "STATUS"       NUMBER,
  "PICKER_ID"    NUMBER,
  "ORDERED"      NUMBER,
  "PICKED"       NUMBER,
  "SEQ"          NUMBER,
  "OUT_DOCK"     NUMBER
);
--------------------------------------------------------
--  DDL for Table PROVIDERS
--------------------------------------------------------

CREATE TABLE "PROVIDERS"
(
  "ID"      NUMBER,
  "NIF"     VARCHAR2(9 BYTE),
  "NAME"    VARCHAR2(100 BYTE),
  "ADDRESS" VARCHAR2(200 BYTE)
);
--------------------------------------------------------
--  DDL for Table RECEIPT_ACTIONS
--------------------------------------------------------

CREATE TABLE "RECEIPT_ACTIONS"
(
  "ID"                NUMBER,
  "REC_ORDER_LINE_ID" NUMBER,
  "DELIVERY_NOTE"     VARCHAR2(100 BYTE),
  "REC_QUANTITY"      NUMBER,
  "RECEIVED_AT"       DATE,
  "USER_ID"           NUMBER,
  "DOCK_ID"           NUMBER
);
--------------------------------------------------------
--  DDL for Table RECEIVING_ORDERS
--------------------------------------------------------

CREATE TABLE "RECEIVING_ORDERS"
(
  "ID"          NUMBER,
  "CODE"        NUMBER,
  "PROVIDER_ID" NUMBER,
  "STATUS"      NUMBER,
  "CREATED_AT"  DATE,
  "UPDATED_AT"  DATE
);
--------------------------------------------------------
--  DDL for Table RECEIVING_ORDERS_LINES
--------------------------------------------------------

CREATE TABLE "RECEIVING_ORDERS_LINES"
(
  "ID"               NUMBER,
  "ORDER_ID"         NUMBER,
  "LINE_NUMBER"      NUMBER,
  "ITEM_ID"          NUMBER,
  "ORDERED_QUANTITY" NUMBER,
  "PENDING_QUANTITY" NUMBER
);
--------------------------------------------------------
--  DDL for Table RECEIVING_ORDERS_STATUS
--------------------------------------------------------

CREATE TABLE "RECEIVING_ORDERS_STATUS"
(
  "ID"          NUMBER,
  "STATUS"      VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE)
);
--------------------------------------------------------
--  DDL for Table ROLE_TYPE
--------------------------------------------------------

CREATE TABLE "ROLE_TYPE"
(
  "ID"          NUMBER,
  "ROLE"        VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(20 BYTE)
);
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

CREATE TABLE "USERS"
(
  "ID"         NUMBER,
  "USERNAME"   VARCHAR2(20 BYTE),
  "PASSWORD"   VARCHAR2(64 BYTE),
  "ENABLED"    NUMBER(1, 0) DEFAULT 0,
  "COMMISSION" NUMBER(*, 2)
);
--------------------------------------------------------
--  DDL for Table USER_ROLES
--------------------------------------------------------

CREATE TABLE "USER_ROLES"
(
  "ID"      NUMBER,
  "ROLE"    NUMBER,
  "USER_ID" NUMBER
);
REM INSERTING into ACTION_STATUS
SET DEFINE OFF;
Insert into ACTION_STATUS (ID,STATUS,DESCRIPTION) values (1,'CR','CREATED');
Insert into ACTION_STATUS (ID,STATUS,DESCRIPTION) values (2,'AS','ASSIGNED');
Insert into ACTION_STATUS (ID,STATUS,DESCRIPTION) values (3,'FI','FINISHED');
REM INSERTING into CONTAINER_STATUS
SET DEFINE OFF;
Insert into CONTAINER_STATUS (ID,STATUS,DESCRIPTION) values (1,'CR','CREATED');
Insert into CONTAINER_STATUS (ID,STATUS,DESCRIPTION) values (2,'DO','IN DOCKS');
Insert into CONTAINER_STATUS (ID,STATUS,DESCRIPTION) values (3,'SH','SHIPPED');
REM INSERTING into DB_VERSION
SET DEFINE OFF;
Insert into DB_VERSION (VERSION) values ('0.1');
REM INSERTING into ORDERS_STATUS
SET DEFINE OFF;
Insert into ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (1,'CR','CREATED');
Insert into ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (2,'PI','PICKING PHASE');
Insert into ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (3,'DO','IN DOCKS');
Insert into ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (4,'SH','SHIPPED');
REM INSERTING into RECEIVING_ORDERS_STATUS
SET DEFINE OFF;
Insert into RECEIVING_ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (1,'CR','CREATED');
Insert into RECEIVING_ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (2,'PR','PARTIALLY RECEIVED');
Insert into RECEIVING_ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (3,'CO','COMPLETED');
Insert into RECEIVING_ORDERS_STATUS (ID,STATUS,DESCRIPTION) values (4,'CL','CLOSED');
REM INSERTING into ROLE_TYPE
SET DEFINE OFF;
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (1,'ROLE_ADMIN','Admins');
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (2,'ROLE_SELLER','Vendedores');
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (3,'ROLE_STORE','Mozos de almacen');
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED,COMMISSION) values (1,'admin','admin',1,null);
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED,COMMISSION) values (2,'seller','seller',1,0.02);
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED,COMMISSION) values (3,'picker','picker',1,null);
REM INSERTING into USER_ROLES
SET DEFINE OFF;
Insert into USER_ROLES (ID,ROLE,USER_ID) values (1,1,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (2,2,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (4,2,2);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (3,3,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (5,3,3);
--------------------------------------------------------
--  DDL for Index ACTION_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ACTION_STATUS_PK" ON "ACTION_STATUS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ACTION_STATUS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ACTION_STATUS_UK1" ON "ACTION_STATUS" ("STATUS")
  ;
--------------------------------------------------------
--  DDL for Index CLIENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CLIENTS_PK" ON "CLIENTS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index CLIENTS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CLIENTS_UK1" ON "CLIENTS" ("NIF")
  ;
--------------------------------------------------------
--  DDL for Index CONTAINER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CONTAINER_PK" ON "CONTAINER" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index CONTAINER_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CONTAINER_STATUS_PK" ON "CONTAINER_STATUS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index CONTAINER_STATUS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CONTAINER_STATUS_UK1" ON "CONTAINER_STATUS" ("STATUS")
  ;
--------------------------------------------------------
--  DDL for Index CONTAINER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CONTAINER_UK1" ON "CONTAINER" ("ORDER_ID")
  ;
--------------------------------------------------------
--  DDL for Index INCOMING_DOCKS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "INCOMING_DOCKS_PK" ON "INCOMING_DOCKS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index INCOMING_DOCKS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "INCOMING_DOCKS_UK1" ON "INCOMING_DOCKS" ("NAME")
  ;
--------------------------------------------------------
--  DDL for Index ITEM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITEM_PK" ON "ITEM" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ITEM_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ITEM_UK1" ON "ITEM" ("CODE")
  ;
--------------------------------------------------------
--  DDL for Index LOCATE_ACTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOCATE_ACTIONS_PK" ON "LOCATE_ACTIONS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index LOCATE_ACTIONS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOCATE_ACTIONS_UK1" ON "LOCATE_ACTIONS" ("RECEIPT_ACTION_ID")
  ;
--------------------------------------------------------
--  DDL for Index LOCATIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOCATIONS_PK" ON "LOCATIONS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index LOCATIONS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOCATIONS_UK1" ON "LOCATIONS" ("CORRIDOR", "SIDE", "MODULE")
  ;
--------------------------------------------------------
--  DDL for Index LOCATIONS_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOCATIONS_UK2" ON "LOCATIONS" ("SEQ")
  ;
--------------------------------------------------------
--  DDL for Index ORDERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDERS_PK" ON "ORDERS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ORDERS_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDERS_STATUS_PK" ON "ORDERS_STATUS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ORDERS_STATUS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDERS_STATUS_UK1" ON "ORDERS_STATUS" ("STATUS")
  ;
--------------------------------------------------------
--  DDL for Index ORDERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDERS_UK1" ON "ORDERS" ("CODE")
  ;
--------------------------------------------------------
--  DDL for Index ORDER_LINES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDER_LINES_PK" ON "ORDERS_LINES" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ORDER_LINES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDER_LINES_UK1" ON "ORDERS_LINES" ("ORDER_ID", "LINE_NUMBER")
  ;
--------------------------------------------------------
--  DDL for Index OUTGOING_DOCKS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "OUTGOING_DOCKS_PK" ON "OUTGOING_DOCKS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index OUTGOING_DOCKS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "OUTGOING_DOCKS_UK1" ON "OUTGOING_DOCKS" ("NAME")
  ;
--------------------------------------------------------
--  DDL for Index PICKING_ACTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICKING_ACTIONS_PK" ON "PICKING_ACTIONS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index PICKING_ACTIONS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICKING_ACTIONS_UK1" ON "PICKING_ACTIONS" ("ORDER_ID", "LINE_ID")
  ;
--------------------------------------------------------
--  DDL for Index PROVIDERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "PROVIDERS_UK1" ON "PROVIDERS" ("NIF")
  ;
--------------------------------------------------------
--  DDL for Index RECEIPT_ACTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIPT_ACTIONS_PK" ON "RECEIPT_ACTIONS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RECEIPT_ACTIONS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIPT_ACTIONS_UK1" ON "RECEIPT_ACTIONS" ("REC_ORDER_LINE_ID", "DELIVERY_NOTE")
  ;
--------------------------------------------------------
--  DDL for Index RECEIVING_ORDERS_LINES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIVING_ORDERS_LINES_PK" ON "RECEIVING_ORDERS_LINES" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RECEIVING_ORDERS_LINES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIVING_ORDERS_LINES_UK1" ON "RECEIVING_ORDERS_LINES" ("ORDER_ID", "LINE_NUMBER")
  ;
--------------------------------------------------------
--  DDL for Index RECEIVING_ORDERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIVING_ORDERS_PK" ON "RECEIVING_ORDERS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RECEIVING_ORDERS_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIVING_ORDERS_STATUS_PK" ON "RECEIVING_ORDERS_STATUS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index RECEIVING_ORDERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "RECEIVING_ORDERS_UK1" ON "RECEIVING_ORDERS" ("CODE")
  ;
--------------------------------------------------------
--  DDL for Index ROLE_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ROLE_TYPE_PK" ON "ROLE_TYPE" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index ROLE_TYPE_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ROLE_TYPE_UK1" ON "ROLE_TYPE" ("ROLE")
  ;
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TABLE1_PK" ON "PROVIDERS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index USER_ROLES_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_ROLES_PK1" ON "USER_ROLES" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index USER_ROLES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_ROLES_UK1" ON "USER_ROLES" ("ROLE", "USER_ID")
  ;
--------------------------------------------------------
--  DDL for Index VERSION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VERSION_PK" ON "DB_VERSION" ("VERSION")
  ;
--------------------------------------------------------
--  Constraints for Table ACTION_STATUS
--------------------------------------------------------

  ALTER TABLE "ACTION_STATUS" ADD CONSTRAINT "ACTION_STATUS_UK1" UNIQUE ("STATUS") ENABLE;
  ALTER TABLE "ACTION_STATUS" ADD CONSTRAINT "ACTION_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ACTION_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "ACTION_STATUS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENTS
--------------------------------------------------------

  ALTER TABLE "CLIENTS" ADD CONSTRAINT "CLIENTS_UK1" UNIQUE ("NIF") ENABLE;
  ALTER TABLE "CLIENTS" ADD CONSTRAINT "CLIENTS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "CLIENTS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "CLIENTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CLIENTS" MODIFY ("NIF" NOT NULL ENABLE);
  ALTER TABLE "CLIENTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CONTAINER
--------------------------------------------------------

  ALTER TABLE "CONTAINER" ADD CONSTRAINT "CONTAINER_UK1" UNIQUE ("ORDER_ID") ENABLE;
  ALTER TABLE "CONTAINER" ADD CONSTRAINT "CONTAINER_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "CONTAINER" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "CONTAINER" MODIFY ("ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "CONTAINER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CONTAINER_STATUS
--------------------------------------------------------

  ALTER TABLE "CONTAINER_STATUS" ADD CONSTRAINT "CONTAINER_STATUS_UK1" UNIQUE ("STATUS") ENABLE;
  ALTER TABLE "CONTAINER_STATUS" ADD CONSTRAINT "CONTAINER_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "CONTAINER_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "CONTAINER_STATUS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DB_VERSION
--------------------------------------------------------

  ALTER TABLE "DB_VERSION" ADD CONSTRAINT "VERSION_PK" PRIMARY KEY ("VERSION") ENABLE;
  ALTER TABLE "DB_VERSION" MODIFY ("VERSION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table INCOMING_DOCKS
--------------------------------------------------------

  ALTER TABLE "INCOMING_DOCKS" ADD CONSTRAINT "INCOMING_DOCKS_UK1" UNIQUE ("NAME") ENABLE;
  ALTER TABLE "INCOMING_DOCKS" ADD CONSTRAINT "INCOMING_DOCKS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "INCOMING_DOCKS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "INCOMING_DOCKS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

  ALTER TABLE "ITEM" ADD CONSTRAINT "ITEM_UK1" UNIQUE ("CODE") ENABLE;
  ALTER TABLE "ITEM" ADD CONSTRAINT "ITEM_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ITEM" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "ITEM" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "ITEM" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "ITEM" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOCATE_ACTIONS
--------------------------------------------------------

  ALTER TABLE "LOCATE_ACTIONS" ADD CONSTRAINT "LOCATE_ACTIONS_UK1" UNIQUE ("RECEIPT_ACTION_ID") ENABLE;
  ALTER TABLE "LOCATE_ACTIONS" ADD CONSTRAINT "LOCATE_ACTIONS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "LOCATE_ACTIONS" MODIFY ("PICKER_ID" NOT NULL ENABLE);
  ALTER TABLE "LOCATE_ACTIONS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "LOCATE_ACTIONS" MODIFY ("RECEIPT_ACTION_ID" NOT NULL ENABLE);
  ALTER TABLE "LOCATE_ACTIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOCATIONS
--------------------------------------------------------

  ALTER TABLE "LOCATIONS" ADD CONSTRAINT "LOCATIONS_UK2" UNIQUE ("SEQ") ENABLE;
  ALTER TABLE "LOCATIONS" ADD CONSTRAINT "LOCATIONS_UK1" UNIQUE ("CORRIDOR", "SIDE", "MODULE") ENABLE;
  ALTER TABLE "LOCATIONS" ADD CONSTRAINT "LOCATIONS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "LOCATIONS" MODIFY ("SEQ" NOT NULL ENABLE);
  ALTER TABLE "LOCATIONS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "LOCATIONS" MODIFY ("MODULE" NOT NULL ENABLE);
  ALTER TABLE "LOCATIONS" MODIFY ("SIDE" NOT NULL ENABLE);
  ALTER TABLE "LOCATIONS" MODIFY ("CORRIDOR" NOT NULL ENABLE);
  ALTER TABLE "LOCATIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" MODIFY ("UPDATED_AT" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" MODIFY ("CREATED_AT" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_UK1" UNIQUE ("CODE") ENABLE;
  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ORDERS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" MODIFY ("CLIENT_ID" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" MODIFY ("SELLER_ID" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "ORDERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS_LINES
--------------------------------------------------------

  ALTER TABLE "ORDERS_LINES" ADD CONSTRAINT "ORDER_LINES_UK1" UNIQUE ("ORDER_ID", "LINE_NUMBER") ENABLE;
  ALTER TABLE "ORDERS_LINES" ADD CONSTRAINT "ORDER_LINES_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ORDERS_LINES" MODIFY ("PENDING_QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_LINES" MODIFY ("ORDERED_QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_LINES" MODIFY ("ITEM_ID" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_LINES" MODIFY ("LINE_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_LINES" MODIFY ("ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_LINES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS_STATUS
--------------------------------------------------------

  ALTER TABLE "ORDERS_STATUS" ADD CONSTRAINT "ORDERS_STATUS_UK1" UNIQUE ("STATUS") ENABLE;
  ALTER TABLE "ORDERS_STATUS" ADD CONSTRAINT "ORDERS_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ORDERS_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "ORDERS_STATUS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OUTGOING_DOCKS
--------------------------------------------------------

  ALTER TABLE "OUTGOING_DOCKS" ADD CONSTRAINT "OUTGOING_DOCKS_UK1" UNIQUE ("NAME") ENABLE;
  ALTER TABLE "OUTGOING_DOCKS" ADD CONSTRAINT "OUTGOING_DOCKS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "OUTGOING_DOCKS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "OUTGOING_DOCKS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PICKING_ACTIONS
--------------------------------------------------------

  ALTER TABLE "PICKING_ACTIONS" MODIFY ("OUT_DOCK" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("SEQ" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_UK1" UNIQUE ("ORDER_ID", "LINE_ID") ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("ORDERED" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("CONTAINER_ID" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("LINE_ID" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "PICKING_ACTIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROVIDERS
--------------------------------------------------------

  ALTER TABLE "PROVIDERS" ADD CONSTRAINT "PROVIDERS_UK1" UNIQUE ("NIF") ENABLE;
  ALTER TABLE "PROVIDERS" ADD CONSTRAINT "PROVIDERS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "PROVIDERS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "PROVIDERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "PROVIDERS" MODIFY ("NIF" NOT NULL ENABLE);
  ALTER TABLE "PROVIDERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECEIPT_ACTIONS
--------------------------------------------------------

  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("DOCK_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" ADD CONSTRAINT "RECEIPT_ACTIONS_UK1" UNIQUE ("REC_ORDER_LINE_ID", "DELIVERY_NOTE") ENABLE;
  ALTER TABLE "RECEIPT_ACTIONS" ADD CONSTRAINT "RECEIPT_ACTIONS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("RECEIVED_AT" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("REC_QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("DELIVERY_NOTE" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("REC_ORDER_LINE_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("REC_ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIPT_ACTIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECEIVING_ORDERS
--------------------------------------------------------

  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("UPDATED_AT" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("CREATED_AT" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("PROVIDER_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" ADD CONSTRAINT "RECEIVING_ORDERS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "RECEIVING_ORDERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS" ADD CONSTRAINT "RECEIVING_ORDERS_UK1" UNIQUE ("CODE") ENABLE;
--------------------------------------------------------
--  Constraints for Table RECEIVING_ORDERS_LINES
--------------------------------------------------------

  ALTER TABLE "RECEIVING_ORDERS_LINES" ADD CONSTRAINT "RECEIVING_ORDERS_LINES_UK1" UNIQUE ("ORDER_ID", "LINE_NUMBER") ENABLE;
  ALTER TABLE "RECEIVING_ORDERS_LINES" ADD CONSTRAINT "RECEIVING_ORDERS_LINES_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("PENDING_QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("ORDERED_QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("ITEM_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("LINE_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_LINES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECEIVING_ORDERS_STATUS
--------------------------------------------------------

  ALTER TABLE "RECEIVING_ORDERS_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "RECEIVING_ORDERS_STATUS" ADD CONSTRAINT "RECEIVING_ORDERS_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "RECEIVING_ORDERS_STATUS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ROLE_TYPE
--------------------------------------------------------

  ALTER TABLE "ROLE_TYPE" ADD CONSTRAINT "ROLE_TYPE_UK1" UNIQUE ("ROLE") ENABLE;
  ALTER TABLE "ROLE_TYPE" ADD CONSTRAINT "ROLE_TYPE_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "ROLE_TYPE" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "ROLE_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" MODIFY ("ENABLED" NOT NULL ENABLE);
  ALTER TABLE "USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_ROLES
--------------------------------------------------------

  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_ROLES_UK1" UNIQUE ("ROLE", "USER_ID") ENABLE;
  ALTER TABLE "USER_ROLES" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "USER_ROLES" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_ROLES_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "USER_ROLES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CLIENTS
--------------------------------------------------------

  ALTER TABLE "CLIENTS" ADD CONSTRAINT "CLIENTS_FK1" FOREIGN KEY ("DEFAULT_DOCK")
	  REFERENCES "OUTGOING_DOCKS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONTAINER
--------------------------------------------------------

  ALTER TABLE "CONTAINER" ADD CONSTRAINT "CONTAINER_FK1" FOREIGN KEY ("STATUS")
	  REFERENCES "CONTAINER_STATUS" ("ID") ENABLE;
  ALTER TABLE "CONTAINER" ADD CONSTRAINT "CONTAINER_FK2" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "ORDERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "CONTAINER" ADD CONSTRAINT "CONTAINER_FK3" FOREIGN KEY ("OUT_DOCK")
	  REFERENCES "OUTGOING_DOCKS" ("ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ITEM
--------------------------------------------------------

  ALTER TABLE "ITEM" ADD CONSTRAINT "ITEM_FK1" FOREIGN KEY ("LOCATION")
	  REFERENCES "LOCATIONS" ("ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOCATE_ACTIONS
--------------------------------------------------------

  ALTER TABLE "LOCATE_ACTIONS" ADD CONSTRAINT "LOCATE_ACTIONS_FK1" FOREIGN KEY ("RECEIPT_ACTION_ID")
	  REFERENCES "RECEIPT_ACTIONS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "LOCATE_ACTIONS" ADD CONSTRAINT "LOCATE_ACTIONS_FK2" FOREIGN KEY ("STATUS")
	  REFERENCES "ACTION_STATUS" ("ID") ENABLE;
  ALTER TABLE "LOCATE_ACTIONS" ADD CONSTRAINT "LOCATE_ACTIONS_FK3" FOREIGN KEY ("PICKER_ID")
	  REFERENCES "USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK1" FOREIGN KEY ("SELLER_ID")
	  REFERENCES "USERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK2" FOREIGN KEY ("CLIENT_ID")
	  REFERENCES "CLIENTS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK3" FOREIGN KEY ("STATUS")
	  REFERENCES "ORDERS_STATUS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS_LINES
--------------------------------------------------------

  ALTER TABLE "ORDERS_LINES" ADD CONSTRAINT "ORDER_LINES_FK1" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "ORDERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "ORDERS_LINES" ADD CONSTRAINT "ORDER_LINES_FK3" FOREIGN KEY ("ITEM_ID")
	  REFERENCES "ITEM" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PICKING_ACTIONS
--------------------------------------------------------

  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK1" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "ORDERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK2" FOREIGN KEY ("LINE_ID")
	  REFERENCES "ORDERS_LINES" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK3" FOREIGN KEY ("CONTAINER_ID")
	  REFERENCES "CONTAINER" ("ID") ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK4" FOREIGN KEY ("PICKER_ID")
	  REFERENCES "USERS" ("ID") ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK5" FOREIGN KEY ("STATUS")
	  REFERENCES "ACTION_STATUS" ("ID") ENABLE;
  ALTER TABLE "PICKING_ACTIONS" ADD CONSTRAINT "PICKING_ACTIONS_FK6" FOREIGN KEY ("OUT_DOCK")
	  REFERENCES "OUTGOING_DOCKS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEIPT_ACTIONS
--------------------------------------------------------

  ALTER TABLE "RECEIPT_ACTIONS" ADD CONSTRAINT "RECEIPT_ACTIONS_FK2" FOREIGN KEY ("REC_ORDER_LINE_ID")
	  REFERENCES "RECEIVING_ORDERS_LINES" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "RECEIPT_ACTIONS" ADD CONSTRAINT "RECEIPT_ACTIONS_FK3" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("ID") ENABLE;
  ALTER TABLE "RECEIPT_ACTIONS" ADD CONSTRAINT "RECEIPT_ACTIONS_FK4" FOREIGN KEY ("DOCK_ID")
	  REFERENCES "INCOMING_DOCKS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEIVING_ORDERS
--------------------------------------------------------

  ALTER TABLE "RECEIVING_ORDERS" ADD CONSTRAINT "RECEIVING_ORDERS_FK1" FOREIGN KEY ("STATUS")
	  REFERENCES "RECEIVING_ORDERS_STATUS" ("ID") ENABLE;
  ALTER TABLE "RECEIVING_ORDERS" ADD CONSTRAINT "RECEIVING_ORDERS_FK2" FOREIGN KEY ("PROVIDER_ID")
	  REFERENCES "PROVIDERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECEIVING_ORDERS_LINES
--------------------------------------------------------

  ALTER TABLE "RECEIVING_ORDERS_LINES" ADD CONSTRAINT "RECEIVING_ORDERS_LINES_FK1" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "RECEIVING_ORDERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "RECEIVING_ORDERS_LINES" ADD CONSTRAINT "RECEIVING_ORDERS_LINES_FK2" FOREIGN KEY ("ITEM_ID")
	  REFERENCES "ITEM" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_ROLES
--------------------------------------------------------

  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_ROLES_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_ROLES_FK2" FOREIGN KEY ("ROLE")
	  REFERENCES "ROLE_TYPE" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  DDL for Trigger CLIENTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CLIENTS_TRG"
BEFORE INSERT ON CLIENTS
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT CLIENTS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CLIENTS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CONTAINER_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "CONTAINER_TRG"
BEFORE INSERT ON CONTAINER
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL THEN
        SELECT CONTAINER_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "CONTAINER_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger INCOMING_DOCKS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "INCOMING_DOCKS_TRG"
BEFORE INSERT ON INCOMING_DOCKS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT INCOMING_DOCKS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "INCOMING_DOCKS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ITEM_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ITEM_TRG"
BEFORE INSERT ON ITEM
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      NULL;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "ITEM_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOCATE_ACTIONS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "LOCATE_ACTIONS_TRG"
BEFORE INSERT ON LOCATE_ACTIONS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT LOCATE_ACTIONS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "LOCATE_ACTIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOCATIONS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "LOCATIONS_TRG"
BEFORE INSERT ON LOCATIONS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT LOCATIONS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "LOCATIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOCATIONS_TRG_NAMING
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "LOCATIONS_TRG_NAMING"
BEFORE INSERT OR UPDATE ON LOCATIONS
FOR EACH ROW
  BEGIN
    SELECT :NEW.CORRIDOR || '-' || :NEW.SIDE || '-' || :NEW.MODULE
    INTO :NEW.NAME
    FROM SYS.DUAL;
  END;
/
ALTER TRIGGER "LOCATIONS_TRG_NAMING" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ORDERS_LINES_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ORDERS_LINES_TRG"
BEFORE INSERT ON ORDERS_LINES
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      NULL;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "ORDERS_LINES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ORDERS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ORDERS_TRG"
BEFORE INSERT ON ORDERS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT ORDERS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "ORDERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ORDERS_TRG_CREATED
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ORDERS_TRG_CREATED"
BEFORE INSERT ON ORDERS
FOR EACH ROW
  BEGIN
    SELECT SYSDATE
    INTO :NEW.CREATED_AT
    FROM SYS.DUAL;
    SELECT SYSDATE
    INTO :NEW.UPDATED_AT
    FROM SYS.DUAL;
  END;
/
ALTER TRIGGER "ORDERS_TRG_CREATED" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ORDERS_TRG_UPDATED
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ORDERS_TRG_UPDATED"
BEFORE UPDATE ON ORDERS
FOR EACH ROW
  BEGIN
    SELECT SYSDATE
    INTO :NEW.UPDATED_AT
    FROM SYS.DUAL;
  END;
/
ALTER TRIGGER "ORDERS_TRG_UPDATED" ENABLE;
--------------------------------------------------------
--  DDL for Trigger OUTGOING_DOCKS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "OUTGOING_DOCKS_TRG"
BEFORE INSERT ON OUTGOING_DOCKS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT OUTGOING_DOCKS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "OUTGOING_DOCKS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PICKING_ACTIONS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "PICKING_ACTIONS_TRG"
BEFORE INSERT ON PICKING_ACTIONS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT PICKING_ACTIONS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "PICKING_ACTIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PROVIDERS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "PROVIDERS_TRG"
BEFORE INSERT ON PROVIDERS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT PROVIDERS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "PROVIDERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECEIPT_ACTIONS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "RECEIPT_ACTIONS_TRG"
BEFORE INSERT ON RECEIPT_ACTIONS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT RECEIPT_ACTIONS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "RECEIPT_ACTIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECEIVING_ORDERS_LINES_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "RECEIVING_ORDERS_LINES_TRG"
BEFORE INSERT ON RECEIVING_ORDERS_LINES
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT RECEIVING_ORDERS_LINES_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "RECEIVING_ORDERS_LINES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECEIVING_ORDERS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "RECEIVING_ORDERS_TRG"
BEFORE INSERT ON RECEIVING_ORDERS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT RECEIVING_ORDERS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "RECEIVING_ORDERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECEIVING_ORDERS_TRG_CREATED
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "RECEIVING_ORDERS_TRG_CREATED"
BEFORE INSERT ON RECEIVING_ORDERS
FOR EACH ROW
  BEGIN
    SELECT SYSDATE
    INTO :NEW.CREATED_AT
    FROM SYS.DUAL;
    SELECT SYSDATE
    INTO :NEW.UPDATED_AT
    FROM SYS.DUAL;
  END;
/
ALTER TRIGGER "RECEIVING_ORDERS_TRG_CREATED" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECEIVING_ORDERS_TRG_UPDATED
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "RECEIVING_ORDERS_TRG_UPDATED"
BEFORE UPDATE ON RECEIVING_ORDERS
FOR EACH ROW
  BEGIN
    SELECT SYSDATE
    INTO :NEW.UPDATED_AT
    FROM SYS.DUAL;
  END;
/
ALTER TRIGGER "RECEIVING_ORDERS_TRG_UPDATED" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "USERS_TRG"
BEFORE INSERT ON USERS
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT USERS_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USER_ROLES_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "USER_ROLES_TRG"
BEFORE INSERT ON USER_ROLES
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT USER_ROLES_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "USER_ROLES_TRG" ENABLE;


--------------------------------------------------------------------------------
-- VERSION 0.2
--------------------------------------------------------------------------------

ALTER TABLE USERS
ADD CONSTRAINT USERS_UK1 UNIQUE
  (
    USERNAME
  )
ENABLE;

UPDATE DB_VERSION
SET VERSION = '0.2';

--------------------------------------------------------------------------------
-- VERSION 0.3
--------------------------------------------------------------------------------

UPDATE USERS
SET password = '$2a$10$uza/2BUK2prXI85rVGzvo.wvzn7zR/hWwFu536KOU2ZUh5WATvr9C';
UPDATE DB_VERSION
SET VERSION = '0.3';

--------------------------------------------------------------------------------
-- VERSION 0.4
--------------------------------------------------------------------------------

INSERT INTO ORDERS_STATUS (ID, STATUS, DESCRIPTION) VALUES (5, 'AS', 'ASSIGNED');
UPDATE DB_VERSION
SET VERSION = '0.4';

--------------------------------------------------------------------------------
-- VERSION 0.5
--------------------------------------------------------------------------------
INSERT INTO PROVIDERS (ID, NIF, NAME, ADDRESS)
VALUES (PROVIDERS_SEQ.nextval, '51094582J', 'PROVIDER 1', 'CALLE DE LA CERDA S/N');
INSERT INTO PROVIDERS (ID, NIF, NAME, ADDRESS)
VALUES (PROVIDERS_SEQ.nextval, '81182528A', 'PROVIDER 2', 'CALLE DEL CERDO S/N');
UPDATE DB_VERSION
SET VERSION = '0.5';
--------------------------------------------------------------------------------
-- VERSION 0.6
--------------------------------------------------------------------------------

INSERT INTO INCOMING_DOCKS (ID, NAME) VALUES (INCOMING_DOCKS_SEQ.nextval, 'ID01');
INSERT INTO INCOMING_DOCKS (ID, NAME) VALUES (INCOMING_DOCKS_SEQ.nextval, 'ID02');
INSERT INTO INCOMING_DOCKS (ID, NAME) VALUES (INCOMING_DOCKS_SEQ.nextval, 'ID03');

UPDATE DB_VERSION
SET VERSION = '0.6';
--------------------------------------------------------------------------------
-- VERSION 0.7
--------------------------------------------------------------------------------

CREATE TABLE "PROYECTO"."STOCK"
(
  "ID"        NUMBER NOT NULL ENABLE,
  "ITEM"      NUMBER NOT NULL ENABLE,
  "LOCATION"  NUMBER,
  "CONTAINER" NUMBER,
  "QUANTITY"  NUMBER NOT NULL ENABLE,
  CONSTRAINT "STOCK_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
    STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ENABLE,
  CONSTRAINT "STOCK_FK1" FOREIGN KEY ("ITEM")
  REFERENCES "PROYECTO"."ITEM" ("ID") ENABLE,
  CONSTRAINT "STOCK_FK2" FOREIGN KEY ("LOCATION")
  REFERENCES "PROYECTO"."LOCATIONS" ("ID") ENABLE,
  CONSTRAINT "STOCK_FK4" FOREIGN KEY ("CONTAINER")
  REFERENCES "PROYECTO"."CONTAINER" ("ID") ENABLE
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
)
TABLESPACE "USERS";

CREATE OR REPLACE TRIGGER "PROYECTO"."STOCK_TRG"
BEFORE INSERT ON STOCK
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT STOCK_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "PROYECTO"."STOCK_TRG" ENABLE;


UPDATE DB_VERSION
SET VERSION = '0.7';
--------------------------------------------------------------------------------
-- VERSION 0.8
--------------------------------------------------------------------------------
