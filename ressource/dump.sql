--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: attribut; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE attribut (
    id integer NOT NULL,
    entite_id integer,
    nom_attribut character varying(50),
    cle_primaire boolean DEFAULT false,
    requis boolean DEFAULT false,
    label character varying(100),
    type character varying(25),
    attribut_unique boolean DEFAULT false,
    foreign_key integer
);


ALTER TABLE public.attribut OWNER TO esp;

--
-- Name: attribut_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE attribut_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.attribut_id_seq OWNER TO esp;

--
-- Name: attribut_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE attribut_id_seq OWNED BY attribut.id;


--
-- Name: attribut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('attribut_id_seq', 4, true);


--
-- Name: entite; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE entite (
    id integer NOT NULL,
    nom_entite character varying(50),
    projet_id integer
);


ALTER TABLE public.entite OWNER TO esp;

--
-- Name: entite_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE entite_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.entite_id_seq OWNER TO esp;

--
-- Name: entite_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE entite_id_seq OWNED BY entite.id;


--
-- Name: entite_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('entite_id_seq', 1, true);


--
-- Name: historique_generation; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE historique_generation (
    id integer NOT NULL,
    projet_id integer,
    date timestamp without time zone
);


ALTER TABLE public.historique_generation OWNER TO esp;

--
-- Name: historique_generation_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE historique_generation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.historique_generation_id_seq OWNER TO esp;

--
-- Name: historique_generation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE historique_generation_id_seq OWNED BY historique_generation.id;


--
-- Name: historique_generation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('historique_generation_id_seq', 1, false);


--
-- Name: projet; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE projet (
    id integer NOT NULL,
    nom_projet character varying(50),
    user_id integer,
    racine_projet character varying(255),
    chemin_lib_struts character varying(500),
    type_base_id integer,
    nom_base character varying(50),
    source_donnees_ds character varying(100)
);


ALTER TABLE public.projet OWNER TO esp;

--
-- Name: projet_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE projet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.projet_id_seq OWNER TO esp;

--
-- Name: projet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE projet_id_seq OWNED BY projet.id;


--
-- Name: projet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('projet_id_seq', 2, true);


--
-- Name: type_base; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE type_base (
    id integer NOT NULL,
    driver character varying(50) NOT NULL,
    dialect character varying(100)
);


ALTER TABLE public.type_base OWNER TO esp;

--
-- Name: type_base_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE type_base_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.type_base_id_seq OWNER TO esp;

--
-- Name: type_base_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE type_base_id_seq OWNED BY type_base.id;


--
-- Name: type_base_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('type_base_id_seq', 23, true);


--
-- Name: user; Type: TABLE; Schema: public; Owner: esp; Tablespace: 
--

CREATE TABLE "user" (
    id integer NOT NULL,
    pseudo character varying(30),
    password character varying(50)
);


ALTER TABLE public."user" OWNER TO esp;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: esp
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO esp;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: esp
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: esp
--

SELECT pg_catalog.setval('user_id_seq', 2, true);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE attribut ALTER COLUMN id SET DEFAULT nextval('attribut_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE entite ALTER COLUMN id SET DEFAULT nextval('entite_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE historique_generation ALTER COLUMN id SET DEFAULT nextval('historique_generation_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE projet ALTER COLUMN id SET DEFAULT nextval('projet_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE type_base ALTER COLUMN id SET DEFAULT nextval('type_base_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: esp
--

ALTER TABLE "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- Data for Name: attribut; Type: TABLE DATA; Schema: public; Owner: esp
--



--
-- Data for Name: entite; Type: TABLE DATA; Schema: public; Owner: esp
--



--
-- Data for Name: historique_generation; Type: TABLE DATA; Schema: public; Owner: esp
--



--
-- Data for Name: projet; Type: TABLE DATA; Schema: public; Owner: esp
--



--
-- Data for Name: type_base; Type: TABLE DATA; Schema: public; Owner: esp
--

INSERT INTO type_base (id, driver, dialect) VALUES (1, 'DB2', 'org.hibernate.dialect.DB2Dialect');
INSERT INTO type_base (id, driver, dialect) VALUES (2, 'DB2 AS/400', 'org.hibernate.dialect.DB2400Dialect');
INSERT INTO type_base (id, driver, dialect) VALUES (3, 'Sybase Anywhere', 'org.hibernate.dialect.SybaseAnywhereDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (4, 'MySQL with InnoDB', 'org.hibernate.dialect.MySQLInnoDBDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (5, 'MySQL with MyISAM', 'org.hibernate.dialect.MySQLMyISAMDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (6, 'HypersonicSQL', 'org.hibernate.dialect.HSQLDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (7, 'Oracle 10g', 'org.hibernate.dialect.Oracle10gDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (8, 'Progress', 'org.hibernate.dialect.ProgressDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (9, 'Oracle (any version)', 'org.hibernate.dialect.OracleDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (10, 'MySQL', 'org.hibernate.dialect.MySQLDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (11, 'FrontBase', 'org.hibernate.dialect.FrontbaseDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (12, 'SAP DB', 'org.hibernate.dialect.SAPDBDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (13, 'Mckoi SQL', 'org.hibernate.dialect.MckoiDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (14, 'Microsoft SQL Server', 'org.hibernate.dialect.SQLServerDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (15, 'DB2 OS390', 'org.hibernate.dialect.DB2390Dialect');
INSERT INTO type_base (id, driver, dialect) VALUES (16, 'Informix', 'org.hibernate.dialect.InformixDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (17, 'Oracle 9i', 'org.hibernate.dialect.Oracle9iDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (18, 'Firebird', 'org.hibernate.dialect.FirebirdDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (19, 'PostgreSQL', 'org.hibernate.dialect.PostgreSQLDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (20, 'Pointbase', 'org.hibernate.dialect.PointbaseDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (21, 'Sybase', 'org.hibernate.dialect.SybaseDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (22, 'Interbase', 'org.hibernate.dialect.InterbaseDialect');
INSERT INTO type_base (id, driver, dialect) VALUES (23, 'Ingres', 'org.hibernate.dialect.IngresDialect');


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: esp
--

INSERT INTO "user" (id, pseudo, password) VALUES (1, 'scicasoft', 'passer');
INSERT INTO "user" (id, pseudo, password) VALUES (2, 'coudy', 'passer');


--
-- Name: attribut_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT attribut_pkey PRIMARY KEY (id);


--
-- Name: entite_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY entite
    ADD CONSTRAINT entite_pkey PRIMARY KEY (id);


--
-- Name: historique_generation_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY historique_generation
    ADD CONSTRAINT historique_generation_pkey PRIMARY KEY (id);


--
-- Name: projet_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT projet_pkey PRIMARY KEY (id);


--
-- Name: type_base_driver_key; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY type_base
    ADD CONSTRAINT type_base_driver_key UNIQUE (driver);


--
-- Name: type_base_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY type_base
    ADD CONSTRAINT type_base_pkey PRIMARY KEY (id);


--
-- Name: unicite_attribut_dans_entite; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT unicite_attribut_dans_entite UNIQUE (entite_id, nom_attribut);


--
-- Name: unicite_entite_dans_projet; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY entite
    ADD CONSTRAINT unicite_entite_dans_projet UNIQUE (nom_entite, projet_id);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user_pseudo_key; Type: CONSTRAINT; Schema: public; Owner: esp; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pseudo_key UNIQUE (pseudo);


--
-- Name: attribut_entite_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT attribut_entite_id_fkey FOREIGN KEY (entite_id) REFERENCES entite(id);


--
-- Name: attribut_foreign_key_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT attribut_foreign_key_fkey FOREIGN KEY (foreign_key) REFERENCES attribut(id);


--
-- Name: entite_projet_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY entite
    ADD CONSTRAINT entite_projet_id_fkey FOREIGN KEY (projet_id) REFERENCES projet(id);


--
-- Name: fk210eb2e93e53f327; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT fk210eb2e93e53f327 FOREIGN KEY (foreign_key) REFERENCES attribut(id);


--
-- Name: fk210eb2e94ee291a4; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY attribut
    ADD CONSTRAINT fk210eb2e94ee291a4 FOREIGN KEY (entite_id) REFERENCES entite(id);


--
-- Name: fkb29de3cf58bc9484; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY entite
    ADD CONSTRAINT fkb29de3cf58bc9484 FOREIGN KEY (projet_id) REFERENCES projet(id);


--
-- Name: fkc5994ccceedccaa4; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT fkc5994ccceedccaa4 FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- Name: fkc5994cccffae6239; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT fkc5994cccffae6239 FOREIGN KEY (type_base_id) REFERENCES type_base(id);


--
-- Name: fkedb8e2da58bc9484; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY historique_generation
    ADD CONSTRAINT fkedb8e2da58bc9484 FOREIGN KEY (projet_id) REFERENCES projet(id);


--
-- Name: historique_generation_projet_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY historique_generation
    ADD CONSTRAINT historique_generation_projet_id_fkey FOREIGN KEY (projet_id) REFERENCES projet(id);


--
-- Name: projet_type_base_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT projet_type_base_id_fkey FOREIGN KEY (type_base_id) REFERENCES type_base(id);


--
-- Name: projet_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: esp
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT projet_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

