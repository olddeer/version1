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

--
-- TOC entry 196 (class 1259 OID 16555)
-- Name: class; Type: TABLE; Schema: public; Owner: postgres
--


CREATE TABLE public.SR_CLASS (
    SRC_ID integer NOT NULL,
    TITLE character varying(255),
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_CLASS OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16558)
-- Name: class_class_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.class_class_id_seq2
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.class_class_id_seq2 OWNER TO postgres;


ALTER SEQUENCE public.class_class_id_seq2 OWNED BY public.SR_CLASS.SRC_ID;




ALTER TABLE ONLY public.SR_CLASS ALTER COLUMN SRC_ID SET DEFAULT nextval('public.class_class_id_seq2'::regclass);


SELECT pg_catalog.setval('public.class_class_id_seq2', 1, true);




ALTER TABLE ONLY public.SR_CLASS
    ADD CONSTRAINT class_pkey PRIMARY KEY (SRC_ID);

