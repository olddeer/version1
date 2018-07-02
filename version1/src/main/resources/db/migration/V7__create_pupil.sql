
CREATE TABLE public.pupil (
    pupil_id integer NOT NULL,
    class_id integer NOT NULL,
    name character varying(255),
    surname character varying(255),
    count_stars integer,
    username character varying(255),
    password character varying(255)
);


ALTER TABLE public.pupil OWNER TO postgres;

CREATE SEQUENCE public.pupil_pupil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pupil_pupil_id_seq OWNER TO postgres;

ALTER SEQUENCE public.pupil_pupil_id_seq OWNED BY public.pupil.pupil_id;

ALTER TABLE ONLY public.pupil ALTER COLUMN pupil_id SET DEFAULT nextval('public.pupil_pupil_id_seq'::regclass);

SELECT pg_catalog.setval('public.pupil_pupil_id_seq', 1, true);

ALTER TABLE ONLY public.pupil
    ADD CONSTRAINT pupil_pkey PRIMARY KEY (pupil_id);
CREATE UNIQUE INDEX pupil_username_uindex ON public.pupil USING btree (username);

ALTER TABLE ONLY public.pupil
    ADD CONSTRAINT pupil_class_id_fkey FOREIGN KEY (class_id) REFERENCES public.class(class_id);