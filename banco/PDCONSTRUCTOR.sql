﻿-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: PDCONSTRUCTOR | type: DATABASE --
-- -- DROP DATABASE IF EXISTS PDCONSTRUCTOR;
-- CREATE DATABASE PDCONSTRUCTOR
-- 	TEMPLATE = pdconstructor
-- ;
-- -- ddl-end --
-- 

-- object: PERFIL | type: TABLE --
-- DROP TABLE IF EXISTS PERFIL CASCADE;
CREATE TABLE PERFIL(
	NOME varchar(100) NOT NULL,
	DESCRICAO text NOT NULL,
	CONSTRAINT PERFIL_PK PRIMARY KEY (NOME)

);
-- ddl-end --
ALTER TABLE PERFIL OWNER TO postgres;
-- ddl-end --

-- object: USUARIO | type: TABLE --
-- DROP TABLE IF EXISTS USUARIO CASCADE;
CREATE TABLE USUARIO(
	NOME varchar(100),
	EMAIL text NOT NULL,
	SENHA text NOT NULL,
	ID serial NOT NULL,
	PERFIL varchar(100) NOT NULL,
	CONSTRAINT USUARIO_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE USUARIO OWNER TO postgres;
-- ddl-end --

-- object: BASE_TEXTO | type: TABLE --
-- DROP TABLE IF EXISTS BASE_TEXTO CASCADE;
CREATE TABLE BASE_TEXTO(
	ID serial NOT NULL,
	TITULO text NOT NULL,
	DESCRICAO text NOT NULL,
	SUPERVISOR integer NOT NULL,
	CONSTRAINT BASE_TEXTO_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE BASE_TEXTO OWNER TO postgres;
-- ddl-end --

-- object: ALOCACAO_TEXTO | type: TABLE --
-- DROP TABLE IF EXISTS ALOCACAO_TEXTO CASCADE;
CREATE TABLE ALOCACAO_TEXTO(
	BASE_TEXTO integer,
	TEXTO text,
	SUPERVISOR integer,
	ID serial NOT NULL,
	CONSTRAINT ALOCACAO_TEXTO_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE ALOCACAO_TEXTO OWNER TO postgres;
-- ddl-end --

-- object: ESCOLHA_CLASSE_TEXTO | type: TABLE --
-- DROP TABLE IF EXISTS ESCOLHA_CLASSE_TEXTO CASCADE;
CREATE TABLE ESCOLHA_CLASSE_TEXTO(
	ID serial NOT NULL,
	DESCRICAO varchar(200) NOT NULL,
	ALOCACAO_TEXTO integer NOT NULL,
	CONSTRAINT ESCOLHA_TEXTO PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE ESCOLHA_CLASSE_TEXTO OWNER TO postgres;
-- ddl-end --

-- object: CLASSIFICACAO_TEXTO | type: TABLE --
-- DROP TABLE IF EXISTS CLASSIFICACAO_TEXTO CASCADE;
CREATE TABLE CLASSIFICACAO_TEXTO(
	ESCRAVO integer NOT NULL,
	ALOCACAO_TEXTO integer NOT NULL,
	ESCOLHA_TEXTO integer NOT NULL,
	CONSTRAINT CLASSIFICACAO_TEXTO_PK PRIMARY KEY (ESCRAVO,ALOCACAO_TEXTO)

);
-- ddl-end --
ALTER TABLE CLASSIFICACAO_TEXTO OWNER TO postgres;
-- ddl-end --

-- object: LIBERACAO_BASE_TEXTO | type: TABLE --
-- DROP TABLE IF EXISTS LIBERACAO_BASE_TEXTO CASCADE;
CREATE TABLE LIBERACAO_BASE_TEXTO(
	BASE_TEXTO integer NOT NULL,
	SUPERVISOR integer NOT NULL,
	ESCRAVO integer NOT NULL,
	STATUS char NOT NULL,
	CONSTRAINT LIBERACAO_BASE_TEXTO_PK PRIMARY KEY (BASE_TEXTO,SUPERVISOR,ESCRAVO)

);
-- ddl-end --
ALTER TABLE LIBERACAO_BASE_TEXTO OWNER TO postgres;
-- ddl-end --

-- object: BASE_IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS BASE_IMAGEM_CLASSE CASCADE;
CREATE TABLE BASE_IMAGEM_CLASSE(
	ID serial NOT NULL,
	TITULO text NOT NULL,
	DESCRICAO text NOT NULL,
	SUPERVISOR integer NOT NULL,
	CONSTRAINT BASE_IMAGEM_CLASSE_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE BASE_IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS IMAGEM_CLASSE CASCADE;
CREATE TABLE IMAGEM_CLASSE(
	ID serial NOT NULL,
	OBJETO bytea NOT NULL,
	SUPERVISOR integer NOT NULL,
	CONSTRAINT IMAGEM_CLASSE_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: ALOCACAO_IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS ALOCACAO_IMAGEM_CLASSE CASCADE;
CREATE TABLE ALOCACAO_IMAGEM_CLASSE(
	ID serial NOT NULL,
	BASE_IMAGEM_CLASSE integer NOT NULL,
	IMAGEM_CLASSE integer NOT NULL,
	SUPERVISOR integer NOT NULL,
	CONSTRAINT ALOCACAO_IMAGEM_CLASSE_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE ALOCACAO_IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: ESCOLHA_IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS ESCOLHA_IMAGEM_CLASSE CASCADE;
CREATE TABLE ESCOLHA_IMAGEM_CLASSE(
	ID serial NOT NULL,
	DESCRICAO text NOT NULL,
	ALOCACAO_IMAGEM_CLASSE integer NOT NULL,
	CONSTRAINT ESCOLHA_IMAGEM_CLASSE_PK PRIMARY KEY (ID)

);
-- ddl-end --
ALTER TABLE ESCOLHA_IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: CLASSSIFICACAO_IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS CLASSSIFICACAO_IMAGEM_CLASSE CASCADE;
CREATE TABLE CLASSSIFICACAO_IMAGEM_CLASSE(
	ESCRAVO integer NOT NULL,
	ALOCACAO_IMAGEM_CLASSE integer NOT NULL,
	ESCOLHA_IMAGEM_CLASSE integer NOT NULL,
	CONSTRAINT CLASSIFICACAO_IMAGEM_CLASSE_PK PRIMARY KEY (ESCRAVO,ALOCACAO_IMAGEM_CLASSE,ESCOLHA_IMAGEM_CLASSE)

);
-- ddl-end --
ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: LIBERACAO_BASE_IMAGEM_CLASSE | type: TABLE --
-- DROP TABLE IF EXISTS LIBERACAO_BASE_IMAGEM_CLASSE CASCADE;
CREATE TABLE LIBERACAO_BASE_IMAGEM_CLASSE(
	BASE_IMAGEM integer NOT NULL,
	SUPERVISOR integer NOT NULL,
	ESCRAVO integer NOT NULL,
	STATUS char NOT NULL,
	CONSTRAINT LIBERACAO_BASE_IMAGEM_CLASSE_PK PRIMARY KEY (BASE_IMAGEM,SUPERVISOR,ESCRAVO)

);
-- ddl-end --
ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE OWNER TO postgres;
-- ddl-end --

-- object: USUARIO_PERFIL_FK | type: CONSTRAINT --
-- ALTER TABLE USUARIO DROP CONSTRAINT IF EXISTS USUARIO_PERFIL_FK CASCADE;
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PERFIL_FK FOREIGN KEY (PERFIL)
REFERENCES PERFIL (NOME) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: BASE_TEXTO_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE BASE_TEXTO DROP CONSTRAINT IF EXISTS BASE_TEXTO_SUPERVISOR_FK CASCADE;
ALTER TABLE BASE_TEXTO ADD CONSTRAINT BASE_TEXTO_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: ALOCACAO_TEXTO_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE ALOCACAO_TEXTO DROP CONSTRAINT IF EXISTS ALOCACAO_TEXTO_SUPERVISOR_FK CASCADE;
ALTER TABLE ALOCACAO_TEXTO ADD CONSTRAINT ALOCACAO_TEXTO_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: ALOCACAO_TEXTO_BASE_TEXTO_FK | type: CONSTRAINT --
-- ALTER TABLE ALOCACAO_TEXTO DROP CONSTRAINT IF EXISTS ALOCACAO_TEXTO_BASE_TEXTO_FK CASCADE;
ALTER TABLE ALOCACAO_TEXTO ADD CONSTRAINT ALOCACAO_TEXTO_BASE_TEXTO_FK FOREIGN KEY (BASE_TEXTO)
REFERENCES BASE_TEXTO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: ESCOLHA_TEXTO_ALOCACAO_TEXTO_FK | type: CONSTRAINT --
-- ALTER TABLE ESCOLHA_CLASSE_TEXTO DROP CONSTRAINT IF EXISTS ESCOLHA_TEXTO_ALOCACAO_TEXTO_FK CASCADE;
ALTER TABLE ESCOLHA_CLASSE_TEXTO ADD CONSTRAINT ESCOLHA_TEXTO_ALOCACAO_TEXTO_FK FOREIGN KEY (ALOCACAO_TEXTO)
REFERENCES ALOCACAO_TEXTO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_TEXTO_ESCRAVO_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSIFICACAO_TEXTO DROP CONSTRAINT IF EXISTS CLASSIFICACAO_TEXTO_ESCRAVO_FK CASCADE;
ALTER TABLE CLASSIFICACAO_TEXTO ADD CONSTRAINT CLASSIFICACAO_TEXTO_ESCRAVO_FK FOREIGN KEY (ESCRAVO)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_TEXTO_ALOCACAO_TEXTO_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSIFICACAO_TEXTO DROP CONSTRAINT IF EXISTS CLASSIFICACAO_TEXTO_ALOCACAO_TEXTO_FK CASCADE;
ALTER TABLE CLASSIFICACAO_TEXTO ADD CONSTRAINT CLASSIFICACAO_TEXTO_ALOCACAO_TEXTO_FK FOREIGN KEY (ALOCACAO_TEXTO)
REFERENCES ALOCACAO_TEXTO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_TEXTO_ESCOLHA_TEXTO_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSIFICACAO_TEXTO DROP CONSTRAINT IF EXISTS CLASSIFICACAO_TEXTO_ESCOLHA_TEXTO_FK CASCADE;
ALTER TABLE CLASSIFICACAO_TEXTO ADD CONSTRAINT CLASSIFICACAO_TEXTO_ESCOLHA_TEXTO_FK FOREIGN KEY (ESCOLHA_TEXTO)
REFERENCES ESCOLHA_CLASSE_TEXTO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_TEXTO_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_TEXTO DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_TEXTO_SUPERVISOR_FK CASCADE;
ALTER TABLE LIBERACAO_BASE_TEXTO ADD CONSTRAINT LIBERACAO_BASE_TEXTO_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_TEXTO_ESCRAVO_FK | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_TEXTO DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_TEXTO_ESCRAVO_FK CASCADE;
ALTER TABLE LIBERACAO_BASE_TEXTO ADD CONSTRAINT LIBERACAO_BASE_TEXTO_ESCRAVO_FK FOREIGN KEY (ESCRAVO)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_TEXTO_BASE_TEXTO_FK | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_TEXTO DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_TEXTO_BASE_TEXTO_FK CASCADE;
ALTER TABLE LIBERACAO_BASE_TEXTO ADD CONSTRAINT LIBERACAO_BASE_TEXTO_BASE_TEXTO_FK FOREIGN KEY (BASE_TEXTO)
REFERENCES BASE_TEXTO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: BASE_IMAGEM_CLASSE_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE BASE_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS BASE_IMAGEM_CLASSE_SUPERVISOR_FK CASCADE;
ALTER TABLE BASE_IMAGEM_CLASSE ADD CONSTRAINT BASE_IMAGEM_CLASSE_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: IMAGEM_CLASSE_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS IMAGEM_CLASSE_SUPERVISOR_FK CASCADE;
ALTER TABLE IMAGEM_CLASSE ADD CONSTRAINT IMAGEM_CLASSE_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: ALOCACAO_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE_FK | type: CONSTRAINT --
-- ALTER TABLE ALOCACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS ALOCACAO_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE_FK CASCADE;
ALTER TABLE ALOCACAO_IMAGEM_CLASSE ADD CONSTRAINT ALOCACAO_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE_FK FOREIGN KEY (BASE_IMAGEM_CLASSE)
REFERENCES BASE_IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: ALOCACAO_IMAGEM_CLASSE_IMAGEM_CLASSE_FK | type: CONSTRAINT --
-- ALTER TABLE ALOCACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS ALOCACAO_IMAGEM_CLASSE_IMAGEM_CLASSE_FK CASCADE;
ALTER TABLE ALOCACAO_IMAGEM_CLASSE ADD CONSTRAINT ALOCACAO_IMAGEM_CLASSE_IMAGEM_CLASSE_FK FOREIGN KEY (IMAGEM_CLASSE)
REFERENCES IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: ALOCACAO_IMAGEM_CLASSE_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE ALOCACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS ALOCACAO_IMAGEM_CLASSE_SUPERVISOR_FK CASCADE;
ALTER TABLE ALOCACAO_IMAGEM_CLASSE ADD CONSTRAINT ALOCACAO_IMAGEM_CLASSE_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: ESCOLHA_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK | type: CONSTRAINT --
-- ALTER TABLE ESCOLHA_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS ESCOLHA_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK CASCADE;
ALTER TABLE ESCOLHA_IMAGEM_CLASSE ADD CONSTRAINT ESCOLHA_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK FOREIGN KEY (ALOCACAO_IMAGEM_CLASSE)
REFERENCES ALOCACAO_IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_IMAGEM_CLASSE_ESCRAVO_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS CLASSIFICACAO_IMAGEM_CLASSE_ESCRAVO_FK CASCADE;
ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE ADD CONSTRAINT CLASSIFICACAO_IMAGEM_CLASSE_ESCRAVO_FK FOREIGN KEY (ESCRAVO)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS CLASSIFICACAO_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK CASCADE;
ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE ADD CONSTRAINT CLASSIFICACAO_IMAGEM_CLASSE_ALOCACAO_IMAGEM_CLASSE_FK FOREIGN KEY (ALOCACAO_IMAGEM_CLASSE)
REFERENCES ALOCACAO_IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: CLASSIFICACAO_IMAGEM_CLASSE_ESCOLHA_IMAGEM_CLASSE_FK | type: CONSTRAINT --
-- ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS CLASSIFICACAO_IMAGEM_CLASSE_ESCOLHA_IMAGEM_CLASSE_FK CASCADE;
ALTER TABLE CLASSSIFICACAO_IMAGEM_CLASSE ADD CONSTRAINT CLASSIFICACAO_IMAGEM_CLASSE_ESCOLHA_IMAGEM_CLASSE_FK FOREIGN KEY (ESCOLHA_IMAGEM_CLASSE)
REFERENCES ESCOLHA_IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE CASCADE;
ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE ADD CONSTRAINT LIBERACAO_BASE_IMAGEM_CLASSE_BASE_IMAGEM_CLASSE FOREIGN KEY (BASE_IMAGEM)
REFERENCES BASE_IMAGEM_CLASSE (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_IMAGEM_CLASSE_SUPERVISOR_FK | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_IMAGEM_CLASSE_SUPERVISOR_FK CASCADE;
ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE ADD CONSTRAINT LIBERACAO_BASE_IMAGEM_CLASSE_SUPERVISOR_FK FOREIGN KEY (SUPERVISOR)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --

-- object: LIBERACAO_BASE_IMAGEM_CLASSE_ESCRAVO_FK | type: CONSTRAINT --
-- ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE DROP CONSTRAINT IF EXISTS LIBERACAO_BASE_IMAGEM_CLASSE_ESCRAVO_FK CASCADE;
ALTER TABLE LIBERACAO_BASE_IMAGEM_CLASSE ADD CONSTRAINT LIBERACAO_BASE_IMAGEM_CLASSE_ESCRAVO_FK FOREIGN KEY (ESCRAVO)
REFERENCES USUARIO (ID) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;
-- ddl-end --


