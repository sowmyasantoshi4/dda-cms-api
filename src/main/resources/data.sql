-- Insert data for table: status
INSERT INTO public.status (status_id, status_name) 
VALUES 
(1, 'Parcel accepted'),
(2, 'In-transit'),
(3, 'Parcel Received at Destination'),
(4, 'Delivered');


-- Insert data for table: designation
INSERT INTO public.designation (designation_id, designation_name) 
VALUES 
(1, 'Administrator'),
(2, 'Branch Incharge'),
(3, 'Delivery Boy'),
(4, 'Staff Member');

-- Insert data for table: states
INSERT INTO public.states (state_id, state_name) 
VALUES 
(1, 'Telangana'),
(2, 'Andhra Pradesh');

-- Insert data for table: districts
INSERT INTO public.districts (district_id, district_name, state_id) 
VALUES 
(1, 'Hyderabad', 1),
(2, 'Medchal-Malkajgiri', 1),
(3, 'Ranga Reddy', 1),
(4, 'Kadapa', 2),
(5, 'Chittoor', 2),
(6, 'Kurnool', 2);


-- Insert data for table: branches
INSERT INTO public.branches (branch_id, branch_name, branch_user_id, city, email_id, house_no, incharge_staff_id, phone_no, pincode, street_no, district_id, state_id) 
VALUES 
(1, 'BANJARA HILLS', 'branch-01', 'BANJARA HILLS', 'branch-01@gmail.com', '4-2-1864/B', 2, '9298809878', 500032, 'Opp. to New Station', 1, 1),
(2, 'KOMPALLY', 'branch-02', 'KOMPALLY', 'branch-02@gmail.com', 'White Homes', 3, '98776532234', 500089, '3', 2, 1),
(3, 'KUKATPALLY', 'branch-03', 'vivek nagar', 'branch-03@gmail.com', 'Sai apartment', 9, '6000000345', 670001, '4', 1, 1);


--
-- Data for Name: staff_members; Type: TABLE DATA; Schema: public; Owner: cmsdb
--
-- Insert data for table: staff_members
INSERT INTO public.staff_members (staff_id, city, email_id, house_no, phone_no, staff_name, street_no, designation_id, branch_id, district_id, state_id, pincode) 
VALUES 
(8, 'ameerpet', 'subhash@gmail.com', 'R123', '9876543210', 'Subhash', 'opp. to showroom', 4, NULL, 4, 2, 500096),
(2, 'Hyderabad', 'jayasuriya@gmail.com', 'B12/A-56', '7842497360', 'Jaya Suriya', '4', 2, 1, 1, 1, 500023),
(4, 'Lalkhilla', 'raju@gmail.com', '206', '9823546671', 'Raju', '2', 3, 1, 1, 1, 500208),
(6, 'as nagar', 'shyam@gmail.com', '34', '8765453622', 'Shyam', '4', 4, 1, 1, 1, 500456),
(1, 'Secunderabad', 'praveena.s@gmail.com', '8-2-1/235', '9247394143', 'Praveena', 'Opp. to passport office lane', 1, NULL, 1, 1, 500987),
(10, 'Aurabad', 'murad@gmail.com', '11', '6000230004', 'Murad', 'patel nagar', 3, NULL, 4, 2, 240001),
(3, 'Narayanguda', 'jayachandra@gmail.com', '1144', '8912621282', 'Jaya Chandra', '5', 2, 2, 2, 1, 500018),
(9, 'Patigadda', 'jaya@gmail.com', '456', '6000000001', 'Jaya', 'zoha nagar', 2, 3, 3, 1, 100005),
(5, 'jawaharnagar', 'ramu@gmail.com', 'Leela homes', '8766551390', 'Ramu', 'opp. to town police', 3, 1, 3, 1, 500023);

 

-- Insert data for table: packages
INSERT INTO public.packages 
(package_id, received_on, receiver_city, receiver_email_id, receiver_house_no, receiver_name, receiver_phone_no, receiver_pincode, receiver_street_no, reference_no, sender_city, sender_email_id, sender_house_no, sender_name, sender_phone_no, sender_pincode, sender_street_no, dispatch_by_staff_id, status_id, receiver_district_id, receiver_state_id, receiving_branch_id, sender_district_id, sender_state_id, sending_branch_id) 
VALUES 
(1, '2023-10-27 11:56:54.305', 'Alwal', 'sruti@gmail.com', '16-26, KistammaEnclave', 'Sruthi', '9876543212', 612333, '4', '2023102701', 'Punjagutta', 'sowmya@gmail.com', '1144', 'Sowmya', '8765432122', 500018, 'Opp. to Voltas Pvt., Ltd.', 5, 4, 3, 1, 2, 1, 1, 1),
(5, '2023-10-27 12:22:12.782', 'test', 'test@gmail.com', 'test', 'testreceiver', '9654565456', 50000, 'test', '2023102702', 'test', 'test@gmail.com', 'test', 'testsender', '7890987890', 500090, 'test', NULL, 3, 5, 2, 1, 3, 1, 2),
(6, '2023-10-27 12:30:47.077', 'ECIL', 'yash@gmail.com', 'A-123', 'Yashwanth', '9876543210', 500201, 'Vidyanagar', '2023102703', 'Sanathnagar', 'santoshi@gmail.com', 'SRT 477', 'Santoshi', '9123456789', 500345, '5', 5, 4, 2, 1, 2, 1, 1, 2),
(7, '2023-10-27 12:35:20.229', 'test', 'test@gmail.com', 'test', 'testreceiver', '9654565456', 50000, 'test', '2023102704', 'test', 'test@gmail.com', 'test', 'testsender', '7890987890', 500090, 'test', NULL, 2, 5, 2, 1, 3, 1, 2);

-- Insert data for table: items
INSERT INTO public.items (item_id, height, item_name, price, weight, width, package_id) 
VALUES 
(1, 15, 'Box', 50, 50, 25, 1),
(2, 20, 'Parcel', 60, 60, 35, 1),
(4, 10, 'Box', 50, 10, 10, 5),
(5, 50, 'Parcel', 150, 650, 45, 6),
(6, 10, 'Application Documents', 25, 10, 10, 6),
(7, 10, 'Box', 50, 10, 10, 7);


-- Insert data for table: packages_status
INSERT INTO public.packages_status (id, remarks, status_updated_on, package_id, status_id) 
VALUES 
(1, NULL, '2023-10-27 11:56:54.337', 1, 1),
(2, 'package added to the transit van', '2023-10-27 12:06:39.968', 1, 2),
(3, 'received !!!', '2023-10-27 12:07:29.481', 1, 3),
(4, 'delivered to customer', '2023-10-27 12:11:57.401', 1, 4),
(5, 'Parcel taken', '2023-10-27 12:22:12.79', 5, 1),
(6, 'package added to the transit van', '2023-10-27 17:45:10.694', 5, 2),
(7, 'received !!!', '2023-10-28 11:45:24.429', 5, 3),
(8, 'Parcel taken', '2023-10-27 12:30:47.087', 6, 1),
(9, 'transitted', '2023-10-27 12:31:34.106', 6, 2),
(10, NULL, '2023-10-27 12:33:51.461', 6, 3),
(11, 'delivered to customer', '2023-10-27 12:34:41.792', 6, 4),
(12, 'Parcel taken', '2023-10-27 12:35:20.241', 7, 1),
(13, NULL, '2023-10-27 12:35:41.181', 7, 2);



--

--
-- Name: branches_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.branches_seq', 3, false);


--
-- Name: designation_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.designation_seq', 4, false);


--
-- Name: items_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.items_seq', 7, false);


--
-- Name: packages_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.packages_seq', 7, false);


--
-- Name: packages_status_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.packages_status_seq', 13, false);


--
-- Name: staff_members_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.staff_members_seq', 10, false);


--
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: cmsdb
--

SELECT pg_catalog.setval('public.user_seq', 1, false);


--
-- Name: branches branch_user_id_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.branches
    ADD CONSTRAINT branch_user_id_uk UNIQUE (branch_user_id);


--
-- Name: branches branches_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.branches
    ADD CONSTRAINT branches_pkey PRIMARY KEY (branch_id);


--
-- Name: designation designation_name_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.designation
    ADD CONSTRAINT designation_name_uk UNIQUE (designation_name);


--
-- Name: designation designation_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.designation
    ADD CONSTRAINT designation_pkey PRIMARY KEY (designation_id);


--
-- Name: districts district_name_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT district_name_uk UNIQUE (district_name);


--
-- Name: districts districts_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT districts_pkey PRIMARY KEY (district_id);


--
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_id);


--
-- Name: packages_status package_status_id_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages_status
    ADD CONSTRAINT package_status_id_uk UNIQUE (package_id, status_id);


--
-- Name: packages packages_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT packages_pkey PRIMARY KEY (package_id);


--
-- Name: packages_status packages_status_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages_status
    ADD CONSTRAINT packages_status_pkey PRIMARY KEY (id);


--
-- Name: staff_members staff_members_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.staff_members
    ADD CONSTRAINT staff_members_pkey PRIMARY KEY (staff_id);


--
-- Name: districts state_district_id_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT state_district_id_uk UNIQUE (district_id, state_id);


--
-- Name: states state_name_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.states
    ADD CONSTRAINT state_name_uk UNIQUE (state_name);


--
-- Name: states states_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.states
    ADD CONSTRAINT states_pkey PRIMARY KEY (state_id);


--
-- Name: status status_name_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_name_uk UNIQUE (status_name);


--
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (status_id);


--
-- Name: packages uk_o6ryickq8c07jb3i4dtrcifuk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT uk_o6ryickq8c07jb3i4dtrcifuk UNIQUE (reference_no);


--
-- Name: users userid_uk; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT userid_uk UNIQUE (user_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: packages fk86guqc8m3nqk7deus3lht9sjy; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fk86guqc8m3nqk7deus3lht9sjy FOREIGN KEY (receiving_branch_id) REFERENCES public.branches(branch_id);


--
-- Name: branches fk8g9is202er14npcbi48hqo7ja; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.branches
    ADD CONSTRAINT fk8g9is202er14npcbi48hqo7ja FOREIGN KEY (state_id) REFERENCES public.states(state_id);


--
-- Name: staff_members fk96y8tmihfwwq4ox2sw0ya5myf; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.staff_members
    ADD CONSTRAINT fk96y8tmihfwwq4ox2sw0ya5myf FOREIGN KEY (designation_id) REFERENCES public.designation(designation_id);


--
-- Name: packages fk9aao885c31rby7ol53ptoyhw4; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fk9aao885c31rby7ol53ptoyhw4 FOREIGN KEY (receiver_state_id) REFERENCES public.states(state_id);


--
-- Name: packages fkcycgfoe1v5416c4414lrbjd2i; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fkcycgfoe1v5416c4414lrbjd2i FOREIGN KEY (sender_district_id) REFERENCES public.districts(district_id);


--
-- Name: branches fkdkdgevg1hibb0g1jlbwk4v6en; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.branches
    ADD CONSTRAINT fkdkdgevg1hibb0g1jlbwk4v6en FOREIGN KEY (district_id) REFERENCES public.districts(district_id);


--
-- Name: staff_members fkelv26gfpjh1y6eesuxasod7hw; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.staff_members
    ADD CONSTRAINT fkelv26gfpjh1y6eesuxasod7hw FOREIGN KEY (district_id) REFERENCES public.districts(district_id);


--
-- Name: packages_status fkg4bhcu6f8vr570453yr1uf871; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages_status
    ADD CONSTRAINT fkg4bhcu6f8vr570453yr1uf871 FOREIGN KEY (package_id) REFERENCES public.packages(package_id);


--
-- Name: staff_members fkhhdkmyfo3vgnek9se26lu6dfp; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.staff_members
    ADD CONSTRAINT fkhhdkmyfo3vgnek9se26lu6dfp FOREIGN KEY (state_id) REFERENCES public.states(state_id);


--
-- Name: packages fkhoj0nppcc34rlok0d986an9el; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fkhoj0nppcc34rlok0d986an9el FOREIGN KEY (receiver_district_id) REFERENCES public.districts(district_id);


--
-- Name: packages_status fkhrjyw1lx614ky0lw9jx7n6gbo; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages_status
    ADD CONSTRAINT fkhrjyw1lx614ky0lw9jx7n6gbo FOREIGN KEY (status_id) REFERENCES public.status(status_id);


--
-- Name: packages fklxlxqv9n2hdayty36ljt19r34; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fklxlxqv9n2hdayty36ljt19r34 FOREIGN KEY (dispatch_by_staff_id) REFERENCES public.staff_members(staff_id);


--
-- Name: packages fklyaawje83w4a9gyv6bmons2n; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fklyaawje83w4a9gyv6bmons2n FOREIGN KEY (sender_state_id) REFERENCES public.states(state_id);


--
-- Name: packages fkm6wdf073dqsdvo4wqv7tblto5; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fkm6wdf073dqsdvo4wqv7tblto5 FOREIGN KEY (status_id) REFERENCES public.status(status_id);


--
-- Name: staff_members fkns6wsrhjxxrap4imiygdje5ng; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.staff_members
    ADD CONSTRAINT fkns6wsrhjxxrap4imiygdje5ng FOREIGN KEY (branch_id) REFERENCES public.branches(branch_id);


--
-- Name: packages fko75mapd19xukpr1u5lal82fyj; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.packages
    ADD CONSTRAINT fko75mapd19xukpr1u5lal82fyj FOREIGN KEY (sending_branch_id) REFERENCES public.branches(branch_id);


--
-- Name: districts fksdoetomqk5jeac0q4wq8e591c; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT fksdoetomqk5jeac0q4wq8e591c FOREIGN KEY (state_id) REFERENCES public.states(state_id);


--
-- Name: items fkt553hq8hn6htidyan8x86lrt; Type: FK CONSTRAINT; Schema: public; Owner: cmsdb
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT fkt553hq8hn6htidyan8x86lrt FOREIGN KEY (package_id) REFERENCES public.packages(package_id);


--
-- PostgreSQL database dump complete
--

