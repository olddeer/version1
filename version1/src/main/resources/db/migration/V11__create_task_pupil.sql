
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


CREATE TYPE public.status_task AS ENUM (
    'In_progress',
    'Done',
    'In_checking'
);

ALTER TYPE public.status_task OWNER TO postgres;

CREATE TABLE public.SR_TASK_PUPIL (
    SRT_P_ID integer NOT NULL,
   SRP_ID integer NOT NULL,
    SRTA_ID integer NOT NULL,
    COUNT integer NOT NULL,
   STATUS public.status_task DEFAULT 'In_progress'::public.status_task,
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_TASK_PUPIL OWNER TO postgres;


CREATE SEQUENCE public.task_pupil_task_pupil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_pupil_task_pupil_id_seq OWNER TO postgres;


ALTER SEQUENCE public.task_pupil_task_pupil_id_seq OWNED BY public.SR_TASK_PUPIL.SRT_P_ID;


ALTER TABLE ONLY public.SR_TASK_PUPIL ALTER COLUMN SRT_P_ID SET DEFAULT nextval('public.task_pupil_task_pupil_id_seq'::regclass);

SELECT pg_catalog.setval('public.task_pupil_task_pupil_id_seq', 4, true);

ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_pkey PRIMARY KEY (SRT_P_ID);

ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_pupil_id_fkey FOREIGN KEY (SRP_ID) REFERENCES public.SR_PUPIL(SRP_ID);
ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_task_id_fkey FOREIGN KEY (SRTA_ID) REFERENCES public.SR_TASK(SRTA_ID);

