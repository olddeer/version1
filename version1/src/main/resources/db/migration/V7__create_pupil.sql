
CREATE TABLE public.SR_PUPIL (
    SRP_ID integer NOT NULL,
    SRC_ID integer NOT NULL,
    NAME character varying(255),
    SURNAME character varying(255),
    COUNT_STARS integer,
   USERNAME character varying(255),
    PASSWORD character varying(255),
    CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_PUPIL OWNER TO postgres;

CREATE SEQUENCE public.pupil_pupil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pupil_pupil_id_seq OWNER TO postgres;

ALTER SEQUENCE public.pupil_pupil_id_seq OWNED BY public.SR_PUPIL.SRP_ID;

ALTER TABLE ONLY public.SR_PUPIL ALTER COLUMN SRP_ID SET DEFAULT nextval('public.pupil_pupil_id_seq'::regclass);

SELECT pg_catalog.setval('public.pupil_pupil_id_seq', 1, true);

ALTER TABLE ONLY public.SR_PUPIL
    ADD CONSTRAINT pupil_pkey PRIMARY KEY (SRP_ID);
CREATE UNIQUE INDEX pupil_username_uindex ON public.SR_PUPIL USING btree (USERNAME);

ALTER TABLE ONLY public.SR_PUPIL
    ADD CONSTRAINT pupil_class_id_fkey FOREIGN KEY (SRC_ID) REFERENCES public.SR_CLASS(SRC_ID);