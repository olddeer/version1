
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE public.SR_TEACHER (
    SRT_ID integer NOT NULL,
    NAME character varying(255) NOT NULL,
    SURNAME character varying(255) NOT NULL,
    EMAIL character varying(255) NOT NULL,
    PHONE character varying(15) NOT NULL,
    CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    USERNAME character varying(255) NOT NULL ,
    PASSWORD character varying(255) NOT NULL
);


ALTER TABLE public.SR_TEACHER OWNER TO postgres;


CREATE SEQUENCE public.teacher_teacher_id_seq2
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teacher_teacher_id_seq2 OWNER TO postgres;


ALTER SEQUENCE public.teacher_teacher_id_seq2 OWNED BY public.SR_TEACHER.SRT_ID;


ALTER TABLE ONLY public.SR_TEACHER ALTER COLUMN SRT_ID SET DEFAULT nextval('public.teacher_teacher_id_seq2'::regclass);



SELECT pg_catalog.setval('public.teacher_teacher_id_seq2', 1, true);




ALTER TABLE ONLY public.SR_TEACHER
    ADD CONSTRAINT teacher_pkey2 PRIMARY KEY (SRT_ID);



