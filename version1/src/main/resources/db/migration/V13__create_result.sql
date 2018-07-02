
CREATE TABLE public.result (
    result_id integer NOT NULL,
    task_pupil_id integer NOT NULL,
    audio character varying(255),
    comment character varying(255)
);


ALTER TABLE public.result OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16574)
-- Name: result_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.result_result_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.result_result_id_seq OWNER TO postgres;


ALTER SEQUENCE public.result_result_id_seq OWNED BY public.result.result_id;



ALTER TABLE ONLY public.result ALTER COLUMN result_id SET DEFAULT nextval('public.result_result_id_seq'::regclass);

SELECT pg_catalog.setval('public.result_result_id_seq', 17, true);


ALTER TABLE ONLY public.result
    ADD CONSTRAINT result_pkey PRIMARY KEY (result_id);



ALTER TABLE ONLY public.result
    ADD CONSTRAINT result_task_pupil_id_fkey FOREIGN KEY (task_pupil_id) REFERENCES public.task_pupil(task_pupil_id);

