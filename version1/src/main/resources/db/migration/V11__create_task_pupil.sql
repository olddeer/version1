
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

CREATE TABLE public.task_pupil (
    task_pupil_id integer NOT NULL,
    pupil_id integer NOT NULL,
    task_id integer NOT NULL,
    count integer NOT NULL,
    status public.status_task DEFAULT 'In_progress'::public.status_task
);


ALTER TABLE public.task_pupil OWNER TO postgres;


CREATE SEQUENCE public.task_pupil_task_pupil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_pupil_task_pupil_id_seq OWNER TO postgres;


ALTER SEQUENCE public.task_pupil_task_pupil_id_seq OWNED BY public.task_pupil.task_pupil_id;


ALTER TABLE ONLY public.task_pupil ALTER COLUMN task_pupil_id SET DEFAULT nextval('public.task_pupil_task_pupil_id_seq'::regclass);

SELECT pg_catalog.setval('public.task_pupil_task_pupil_id_seq', 4, true);

ALTER TABLE ONLY public.task_pupil
    ADD CONSTRAINT task_pupil_pkey PRIMARY KEY (task_pupil_id);

ALTER TABLE ONLY public.task_pupil
    ADD CONSTRAINT task_pupil_pupil_id_fkey FOREIGN KEY (pupil_id) REFERENCES public.pupil(pupil_id);
ALTER TABLE ONLY public.task_pupil
    ADD CONSTRAINT task_pupil_task_id_fkey FOREIGN KEY (task_id) REFERENCES public.task(task_id);

