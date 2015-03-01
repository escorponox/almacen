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