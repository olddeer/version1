
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


CREATE TABLE public.SR_TASK (
    SRTA_ID integer NOT NULL,
    DESCRIPTION character varying,
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_TASK OWNER TO postgres;

CREATE SEQUENCE public.task_task_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_task_id_seq OWNER TO postgres;



ALTER SEQUENCE public.task_task_id_seq OWNED BY public.SR_TASK.SRTA_ID;



ALTER TABLE ONLY public.SR_TASK ALTER COLUMN SRTA_ID SET DEFAULT nextval('public.task_task_id_seq'::regclass);


SELECT pg_catalog.setval('public.task_task_id_seq', 1, true);


ALTER TABLE ONLY public.SR_TASK
    ADD CONSTRAINT task_pkey PRIMARY KEY (SRTA_ID);

