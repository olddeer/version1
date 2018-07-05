
CREATE TABLE public.SR_AUDIO(
SRA_ID integer NOT NULL,
PATH character varying(255)
);




ALTER TABLE ONLY public.SR_AUDIO
    ADD CONSTRAINT audio_pkey PRIMARY KEY (SRA_ID);







CREATE SEQUENCE public.audio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.audio_id_seq OWNER TO postgres;


ALTER SEQUENCE public.audio_id_seq OWNED BY public.SR_AUDIO.SRA_ID;



ALTER TABLE ONLY public.SR_AUDIO ALTER COLUMN SRA_ID SET DEFAULT nextval('public.audio_id_seq'::regclass);

ALTER TABLE public.SR_AUDIO OWNER TO postgres;

SELECT pg_catalog.setval('audio_id_seq', 3, true);
INSERT INTO SR_AUDIO VALUES (1,'C:/somewhere');
INSERT INTO SR_AUDIO VALUES (2,'D:/somewhere');
INSERT INTO SR_AUDIO VALUES (3,'E:/somewhere');


CREATE TABLE public.SR_RESULT (
   SRR_ID integer NOT NULL,
    SRT_P_ID integer NOT NULL,
    SRA_ID integer NOT NULL,
    COMMENT character varying(255) NOT NULL,
      CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()

);



ALTER TABLE public.SR_RESULT OWNER TO postgres;

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


ALTER SEQUENCE public.result_result_id_seq OWNED BY public.SR_RESULT.SRR_ID;



ALTER TABLE ONLY public.SR_RESULT ALTER COLUMN SRR_ID SET DEFAULT nextval('public.result_result_id_seq'::regclass);

SELECT pg_catalog.setval('public.result_result_id_seq', 17, true);


ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_pkey PRIMARY KEY (SRR_ID);



ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_task_pupil_id_fkey FOREIGN KEY (SRT_P_ID) REFERENCES public.SR_TASK_PUPIL(SRT_P_ID);

ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_task_pupil_id_fkey2 FOREIGN KEY (SRA_ID) REFERENCES public.SR_AUDIO(SRA_ID);
