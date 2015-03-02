--------------------------------------------------------
--  DDL for Sequence CLIENTS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "CLIENTS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ITEM_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ITEM_SEQ" MINVALUE 100000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 100000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ORDERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ORDERS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence ORDER_LINES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "ORDER_LINES_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USERS_SEQ" MINVALUE 1000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence USER_ROLES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USER_ROLES_SEQ" MINVALUE 1000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Table CLIENTS
--------------------------------------------------------

CREATE TABLE "CLIENTS"
(
  "ID"      NUMBER,
  "NIF"     NUMBER,
  "NAME"    VARCHAR2(100 BYTE),
  "ADDRESS" VARCHAR2(200 BYTE)
);
--------------------------------------------------------
--  DDL for Table DB_VERSION
--------------------------------------------------------

CREATE TABLE "DB_VERSION"
(
  "VERSION" VARCHAR2(20 BYTE)
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
  "PRICE"       NUMBER(*, 2) DEFAULT 1
);
--------------------------------------------------------
--  DDL for Table LINE_STATUS
--------------------------------------------------------

CREATE TABLE "LINE_STATUS"
(
  "ID"          NUMBER,
  "STATUS"      VARCHAR2(20 BYTE),
  "DESCRIPTION" VARCHAR2(100 BYTE)
);
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

CREATE TABLE "ORDERS"
(
  "ID"              NUMBER,
  "CODE"            NUMBER,
  "SELLER_ID"       NUMBER,
  "CLIENT_ID"       NUMBER,
  "ORDER_STATUS_ID" NUMBER
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
--  DDL for Table ORDER_LINES
--------------------------------------------------------

CREATE TABLE "ORDER_LINES"
(
  "ID"               NUMBER,
  "ORDER_ID"         NUMBER,
  "LINE_NUMBER"      NUMBER,
  "ITEM_ID"          NUMBER,
  "ORDERED_QUANTITY" NUMBER,
  "PENDING_QUANTITY" NUMBER,
  "LINE_STATUS"      NUMBER
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
  "ID"       NUMBER,
  "USERNAME" VARCHAR2(20 BYTE),
  "PASSWORD" VARCHAR2(64 BYTE),
  "ENABLED"  NUMBER(1, 0) DEFAULT 0
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
REM INSERTING into DB_VERSION
SET DEFINE OFF;
Insert into DB_VERSION (VERSION) values ('0.1');
REM INSERTING into LINE_STATUS
SET DEFINE OFF;
REM INSERTING into ORDERS_STATUS
SET DEFINE OFF;
REM INSERTING into ROLE_TYPE
SET DEFINE OFF;
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (1,'ROLE_ADMIN','Admins');
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (2,'ROLE_SELLER','Vendedores');
Insert into ROLE_TYPE (ID,ROLE,DESCRIPTION) values (3,'ROLE_STORE','Mozos de almacen');
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED) values (1,'admin','admin',1);
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED) values (2,'seller','seller',1);
Insert into USERS (ID,USERNAME,PASSWORD,ENABLED) values (3,'picker','picker',1);
REM INSERTING into USER_ROLES
SET DEFINE OFF;
Insert into USER_ROLES (ID,ROLE,USER_ID) values (1,1,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (2,2,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (4,2,2);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (3,3,1);
Insert into USER_ROLES (ID,ROLE,USER_ID) values (5,3,3);
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
--  DDL for Index ITEM_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "ITEM_PK" ON "ITEM" ("ID")
;
--------------------------------------------------------
--  DDL for Index LINE_STATUS_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "LINE_STATUS_PK" ON "LINE_STATUS" ("ID")
;
--------------------------------------------------------
--  DDL for Index LINE_STATUS_UK1
--------------------------------------------------------

CREATE UNIQUE INDEX "LINE_STATUS_UK1" ON "LINE_STATUS" ("STATUS")
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

CREATE UNIQUE INDEX "ORDER_LINES_PK" ON "ORDER_LINES" ("ID")
;
--------------------------------------------------------
--  DDL for Index ORDER_LINES_UK1
--------------------------------------------------------

CREATE UNIQUE INDEX "ORDER_LINES_UK1" ON "ORDER_LINES" ("ORDER_ID", "LINE_NUMBER")
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
--  Constraints for Table CLIENTS
--------------------------------------------------------

ALTER TABLE "CLIENTS" ADD CONSTRAINT "CLIENTS_UK1" UNIQUE ("NIF") ENABLE;
ALTER TABLE "CLIENTS" ADD CONSTRAINT "CLIENTS_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "CLIENTS" MODIFY ("ADDRESS" NOT NULL ENABLE);
ALTER TABLE "CLIENTS" MODIFY ("NAME" NOT NULL ENABLE);
ALTER TABLE "CLIENTS" MODIFY ("NIF" NOT NULL ENABLE);
ALTER TABLE "CLIENTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DB_VERSION
--------------------------------------------------------

ALTER TABLE "DB_VERSION" ADD CONSTRAINT "VERSION_PK" PRIMARY KEY ("VERSION") ENABLE;
ALTER TABLE "DB_VERSION" MODIFY ("VERSION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

ALTER TABLE "ITEM" ADD CONSTRAINT "ITEM_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "ITEM" MODIFY ("PRICE" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("NAME" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("CODE" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LINE_STATUS
--------------------------------------------------------

ALTER TABLE "LINE_STATUS" ADD CONSTRAINT "LINE_STATUS_UK1" UNIQUE ("STATUS") ENABLE;
ALTER TABLE "LINE_STATUS" ADD CONSTRAINT "LINE_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "LINE_STATUS" MODIFY ("ID" NOT NULL ENABLE);
ALTER TABLE "LINE_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_UK1" UNIQUE ("CODE") ENABLE;
ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "ORDERS" MODIFY ("ORDER_STATUS_ID" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("CLIENT_ID" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("SELLER_ID" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("CODE" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS_STATUS
--------------------------------------------------------

ALTER TABLE "ORDERS_STATUS" ADD CONSTRAINT "ORDERS_STATUS_UK1" UNIQUE ("STATUS") ENABLE;
ALTER TABLE "ORDERS_STATUS" ADD CONSTRAINT "ORDERS_STATUS_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "ORDERS_STATUS" MODIFY ("STATUS" NOT NULL ENABLE);
ALTER TABLE "ORDERS_STATUS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDER_LINES
--------------------------------------------------------

ALTER TABLE "ORDER_LINES" ADD CONSTRAINT "ORDER_LINES_UK1" UNIQUE ("ORDER_ID", "LINE_NUMBER") ENABLE;
ALTER TABLE "ORDER_LINES" ADD CONSTRAINT "ORDER_LINES_PK" PRIMARY KEY ("ID") ENABLE;
ALTER TABLE "ORDER_LINES" MODIFY ("LINE_STATUS" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("PENDING_QUANTITY" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("ORDERED_QUANTITY" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("ITEM_ID" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("LINE_NUMBER" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("ORDER_ID" NOT NULL ENABLE);
ALTER TABLE "ORDER_LINES" MODIFY ("ID" NOT NULL ENABLE);
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
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK1" FOREIGN KEY ("SELLER_ID")
REFERENCES "USERS" ("ID") ON DELETE CASCADE ENABLE;
ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK2" FOREIGN KEY ("ID")
REFERENCES "CLIENTS" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDER_LINES
--------------------------------------------------------

ALTER TABLE "ORDER_LINES" ADD CONSTRAINT "ORDER_LINES_FK1" FOREIGN KEY ("ORDER_ID")
REFERENCES "ORDERS" ("ID") ON DELETE CASCADE ENABLE;
ALTER TABLE "ORDER_LINES" ADD CONSTRAINT "ORDER_LINES_FK2" FOREIGN KEY ("LINE_STATUS")
REFERENCES "LINE_STATUS" ("ID") ENABLE;
ALTER TABLE "ORDER_LINES" ADD CONSTRAINT "ORDER_LINES_FK3" FOREIGN KEY ("ITEM_ID")
REFERENCES "ITEM" ("ID") ON DELETE CASCADE ENABLE;
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
--  DDL for Trigger ITEM_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ITEM_TRG"
BEFORE INSERT ON ITEM
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT ITEM_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "ITEM_TRG" ENABLE;
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
--  DDL for Trigger ORDER_LINES_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ORDER_LINES_TRG"
BEFORE INSERT ON ORDER_LINES
FOR EACH ROW
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.ID IS NULL
      THEN
        SELECT ORDER_LINES_SEQ.NEXTVAL
        INTO :NEW.ID
        FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
/
ALTER TRIGGER "ORDER_LINES_TRG" ENABLE;
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
