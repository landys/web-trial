
--
-- Name: applicants_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE applicants_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- Name: applicants; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE applicants (
    id integer DEFAULT nextval('applicants_id_seq'::regclass) NOT NULL,
    email character varying not null,
    full_name character varying not null,
	mobilephone character varying not null,
	update_time timestamp NOT NULL,
	ip_address character varying NOT NULL
);

--
-- Name: trials_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE trials_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

--
-- Name: trials; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE trials (
    id integer DEFAULT nextval('trials_id_seq'::regclass) NOT NULL,
    mobilephone character varying not null,
	update_time timestamp NOT NULL,
	ip_address character varying NOT NULL
);

--
-- Name: applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);


--
-- Name: trials_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY trials
    ADD CONSTRAINT trials_pkey PRIMARY KEY (id);
