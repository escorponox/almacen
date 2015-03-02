--------------------------------------------------------
--  File created - Sunday-March-01-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USERS_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Sequence USER_ROLES_SEQ
--------------------------------------------------------

CREATE SEQUENCE "USER_ROLES_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER NOCYCLE;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

CREATE TABLE "USERS"
(
  "ID"       NUMBER,
  "USERNAME" VARCHAR2(20 BYTE),
  "PASSWORD" VARCHAR2(64 BYTE),
  "ENABLED"  NUMBER(1, 0) DEFAULT 1
);
--------------------------------------------------------
--  DDL for Table USER_ROLES
--------------------------------------------------------

CREATE TABLE "USER_ROLES"
(
  "ID"      NUMBER,
  "ROLE"    VARCHAR2(40 BYTE),
  "USER_ID" NUMBER
);
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("ID");
--------------------------------------------------------
--  DDL for Index USER_ROLES_PK1
--------------------------------------------------------

CREATE UNIQUE INDEX "USER_ROLES_PK1" ON "USER_ROLES" ("ID");
--------------------------------------------------------
--  DDL for Index USER_ROLES_UK1
--------------------------------------------------------

CREATE UNIQUE INDEX "USER_ROLES_UK1" ON "USER_ROLES" ("ROLE", "USER_ID");
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
--  Ref Constraints for Table USER_ROLES
--------------------------------------------------------

ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_ROLES_FK1" FOREIGN KEY ("USER_ID")
REFERENCES "USERS" ("ID") ON DELETE CASCADE ENABLE;
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
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
)
TABLESPACE "USERS";
--------------------------------------------------------
--  DDL for Index ITEM_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "ITEM_PK" ON "ITEM" ("ID")
PCTFREE 10 INITRANS 2 MAXTRANS 255
STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT )
TABLESPACE "USERS";
--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

ALTER TABLE "ITEM" ADD CONSTRAINT "ITEM_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ENABLE;
ALTER TABLE "ITEM" MODIFY ("PRICE" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("NAME" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("CODE" NOT NULL ENABLE);
ALTER TABLE "ITEM" MODIFY ("ID" NOT NULL ENABLE);
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
--  DDL for Table DB_VERSION
--------------------------------------------------------

CREATE TABLE "DB_VERSION"
(
  "VERSION" VARCHAR2(20 BYTE)
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
)
TABLESPACE "USERS";
--------------------------------------------------------
--  DDL for Index VERSION_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "VERSION_PK" ON "DB_VERSION" ("VERSION")
PCTFREE 10 INITRANS 2 MAXTRANS 255
STORAGE ( INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT )
TABLESPACE "USERS";
--------------------------------------------------------
--  Constraints for Table DB_VERSION
--------------------------------------------------------

ALTER TABLE "DB_VERSION" ADD CONSTRAINT "VERSION_PK" PRIMARY KEY ("VERSION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255
  STORAGE (INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ENABLE;
ALTER TABLE "DB_VERSION" MODIFY ("VERSION" NOT NULL ENABLE);


INSERT INTO DB_VERSION VALUES ('0.1');

--------------------------------------------------------------------------------
-- VERSION 0.2
--------------------------------------------------------------------------------
