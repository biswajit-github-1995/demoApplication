-- Drop table

-- DROP TABLE public."user_details";

CREATE TABLE public."user_details" (
	user_id bigserial NOT NULL,
	user_name varchar NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar NULL,
	phone_no int8 NULL,
	created_on date NULL,
	created_by varchar NULL,
	updated_on date NULL,
	updated_by varchar NULL,
	CONSTRAINT user_pk PRIMARY KEY (user_id)
);