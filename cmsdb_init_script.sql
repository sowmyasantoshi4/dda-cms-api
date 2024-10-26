--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

CREATE ROLE cmsdb WITH LOGIN PASSWORD 'cmsdb';

-- Create the database with the owner
CREATE DATABASE cmsdb WITH OWNER cmsdb;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;
  
--
-- PostgreSQL database dump complete
--


CREATE TABLE IF NOT EXISTS public.branches (
    branch_id integer NOT NULL,
    branch_name character varying(100) NOT NULL,
    branch_user_id character varying(25) NOT NULL,
    city character varying(50) NOT NULL,
    email_id character varying(50) NOT NULL,
    house_no character varying(50) NOT NULL,
    phone_no character varying(25) NOT NULL,
    pincode character varying(255) NOT NULL,
    street_no character varying(50) NOT NULL,
    district_id integer NOT NULL,
    state_id integer NOT NULL,
    incharge_staff_id integer NOT NULL
);


ALTER TABLE public.branches OWNER TO cmsdb;

--
-- Name: branches_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.branches_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.branches_seq OWNER TO cmsdb;

--
-- Name: designation; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.designation (
    designation_id integer NOT NULL,
    designation_name character varying(50) NOT NULL
);


ALTER TABLE public.designation OWNER TO cmsdb;

--
-- Name: designation_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.designation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.designation_seq OWNER TO cmsdb;

--
-- Name: districts; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.districts (
    district_id integer NOT NULL,
    district_name character varying(50) NOT NULL,
    state_id integer NOT NULL
);


ALTER TABLE public.districts OWNER TO cmsdb;

--
-- Name: items; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.items (
    item_id integer NOT NULL,
    height double precision NOT NULL,
    item_name character varying(100) NOT NULL,
    price double precision NOT NULL,
    weight double precision NOT NULL,
    width double precision NOT NULL,
    package_id integer NOT NULL
);


ALTER TABLE public.items OWNER TO cmsdb;

--
-- Name: items_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.items_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_seq OWNER TO cmsdb;

--
-- Name: packages; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.packages (
    package_id integer NOT NULL,
    received_on timestamp without time zone NOT NULL,
    receiver_city character varying(50) NOT NULL,
    receiver_email_id character varying(50) NOT NULL,
    receiver_house_no character varying(50) NOT NULL,
    receiver_name character varying(50) NOT NULL,
    receiver_phone_no character varying(25) NOT NULL,
    receiver_pincode character varying(10) NOT NULL,
    receiver_street_no character varying(50) NOT NULL,
    reference_no integer NOT NULL,
    sender_city character varying(50) NOT NULL,
    sender_email_id character varying(50) NOT NULL,
    sender_house_no character varying(50) NOT NULL,
    sender_name character varying(50) NOT NULL,
    sender_phone_no character varying(25) NOT NULL,
    sender_pincode character varying(10) NOT NULL,
    sender_street_no character varying(50) NOT NULL,
    dispatch_by_staff_id integer,
    status_id integer NOT NULL,
    receiver_district_id integer NOT NULL,
    receiver_state_id integer NOT NULL,
    receiving_branch_id integer NOT NULL,
    sender_district_id integer NOT NULL,
    sender_state_id integer NOT NULL,
    sending_branch_id integer NOT NULL
);


ALTER TABLE public.packages OWNER TO cmsdb;

--
-- Name: packages_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.packages_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.packages_seq OWNER TO cmsdb;

--
-- Name: packages_status; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.packages_status (
    id integer NOT NULL,
    remarks character varying(255),
    status_updated_on timestamp without time zone NOT NULL,
    package_id integer NOT NULL,
    status_id integer NOT NULL
);


ALTER TABLE public.packages_status OWNER TO cmsdb;

--
-- Name: packages_status_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.packages_status_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.packages_status_seq OWNER TO cmsdb;

--
-- Name: staff_members; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.staff_members (
    staff_id integer NOT NULL,
    city character varying(50) NOT NULL,
    email_id character varying(50) NOT NULL,
    house_no character varying(50) NOT NULL,
    phone_no character varying(10) NOT NULL,
    pincode character varying(6) NOT NULL,
    staff_name character varying(50) NOT NULL,
    street_no character varying(50) NOT NULL,
    designation_id integer NOT NULL,
    branch_id integer,
    district_id integer,
    state_id integer
);


ALTER TABLE public.staff_members OWNER TO cmsdb;

--
-- Name: staff_members_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.staff_members_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_members_seq OWNER TO cmsdb;

--
-- Name: states; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.states (
    state_id integer NOT NULL,
    state_name character varying(50) NOT NULL
);


ALTER TABLE public.states OWNER TO cmsdb;

--
-- Name: status; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.status (
    status_id integer NOT NULL,
    status_name character varying(40) NOT NULL
);


ALTER TABLE public.status OWNER TO cmsdb;

--
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: cmsdb
--

CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_seq OWNER TO cmsdb;

--
-- Name: users; Type: TABLE; Schema: public; Owner: cmsdb
--

CREATE TABLE IF NOT EXISTS public.users (
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25),
    password character varying(200) NOT NULL,
    user_name character varying(25) NOT NULL,
    slno integer NOT NULL,
    user_desc character varying(25) NOT NULL,
    encpassword character varying(200) NOT NULL,
    role_id integer,
    role character varying(255)
);


ALTER TABLE public.users OWNER TO cmsdb;

