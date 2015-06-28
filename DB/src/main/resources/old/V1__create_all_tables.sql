-- Created by Vertabelo (http://vertabelo.com)
-- Script type: create
-- Scope: [tables, references, sequences, views, procedures]
-- Generated at Sat Jan 31 12:03:36 UTC 2015




-- tables
-- Table: carnet
CREATE TABLE carnet (
    id int  NOT NULL,
    number varchar(20)  NOT NULL,
    purchase_date date  NOT NULL,
    client_id int  NOT NULL,
    CONSTRAINT carnet_pk PRIMARY KEY (id)
);



-- Table: carnet_usage
CREATE TABLE carnet_usage (
    id int  NOT NULL,
    hours int  NOT NULL,
    carnet_id int  NOT NULL,
    reservation_id int  NOT NULL,
    CONSTRAINT carnet_usage_pk PRIMARY KEY (id)
);



-- Table: client
CREATE TABLE client (
    id int  NOT NULL,
    name varchar(200)  NULL,
    password varchar(200)  NULL,
    band_name varchar(200)  NOT NULL,
    phone_numer varchar(200)  NULL,
    email varchar(200)  NULL,
    postal_code varchar(10)  NULL,
    street varchar(200)  NULL,
    city int  NULL,
    NIP varchar(10)  NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);



-- Table: cost
CREATE TABLE cost (
    id int  NOT NULL,
    date date  NOT NULL,
    cost decimal(5,2)  NOT NULL,
    description varchar(200)  NULL,
    cost_subcategory_id int  NOT NULL,
    CONSTRAINT cost_pk PRIMARY KEY (id)
);



-- Table: cost_category
CREATE TABLE cost_category (
    id int  NOT NULL,
    name varchar(100)  NOT NULL,
    CONSTRAINT cost_category_pk PRIMARY KEY (id)
);



-- Table: cost_subcategory
CREATE TABLE cost_subcategory (
    id int  NOT NULL,
    name varchar(100)  NOT NULL,
    cost_category_id int  NOT NULL,
    CONSTRAINT cost_subcategory_pk PRIMARY KEY (id)
);



-- Table: income
CREATE TABLE income (
    id int  NOT NULL,
    amount decimal(3,2)  NOT NULL,
    income_category_id int  NOT NULL,
    reservation_id int  NOT NULL,
    date date  NOT NULL,
    CONSTRAINT income_pk PRIMARY KEY (id)
);



-- Table: income_category
CREATE TABLE income_category (
    id int  NOT NULL,
    name varchar(100)  NOT NULL,
    CONSTRAINT income_category_pk PRIMARY KEY (id)
);



-- Table: reservation
CREATE TABLE reservation (
    id int  NOT NULL,
    client_id int  NOT NULL,
    reservation_category_id int  NOT NULL,
    date date  NOT NULL,
    hour_start time  NOT NULL,
    hours_end time  NOT NULL,
    is_paid boolean  NOT NULL,
    is_approved boolean  NOT NULL,
    is_cymbals boolean  NOT NULL,
    is_piano boolean  NOT NULL,
    contact_person_name varchar(200)  NULL,
    contact_person_phone varchar(200)  NULL,
    band_name varchar(200)  NULL,
    conctact_person_email varchar(200)  NULL,
    CONSTRAINT reservation_pk PRIMARY KEY (id)
);



-- Table: reservation_category
CREATE TABLE reservation_category (
    id int  NOT NULL,
    name varchar(100)  NOT NULL,
    CONSTRAINT reservation_category_pk PRIMARY KEY (id)
);







-- foreign keys
-- Reference:  carnet_client (table: carnet)


ALTER TABLE carnet ADD CONSTRAINT carnet_client
    FOREIGN KEY (client_id)
    REFERENCES client (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  carnet_usage_carnet (table: carnet_usage)


ALTER TABLE carnet_usage ADD CONSTRAINT carnet_usage_carnet
    FOREIGN KEY (carnet_id)
    REFERENCES carnet (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  carnet_usage_reservation (table: carnet_usage)


ALTER TABLE carnet_usage ADD CONSTRAINT carnet_usage_reservation
    FOREIGN KEY (reservation_id)
    REFERENCES reservation (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  cost_subcategory_cost (table: cost)


ALTER TABLE cost ADD CONSTRAINT cost_subcategory_cost
    FOREIGN KEY (cost_subcategory_id)
    REFERENCES cost_subcategory (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  cost_subcategory_cost_category (table: cost_subcategory)


ALTER TABLE cost_subcategory ADD CONSTRAINT cost_subcategory_cost_category
    FOREIGN KEY (cost_category_id)
    REFERENCES cost_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  income_income_category (table: income)


ALTER TABLE income ADD CONSTRAINT income_income_category
    FOREIGN KEY (income_category_id)
    REFERENCES income_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  income_reservation (table: income)


ALTER TABLE income ADD CONSTRAINT income_reservation
    FOREIGN KEY (reservation_id)
    REFERENCES reservation (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  reservation_client (table: reservation)


ALTER TABLE reservation ADD CONSTRAINT reservation_client
    FOREIGN KEY (client_id)
    REFERENCES client (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  reservation_reservation_category (table: reservation)


ALTER TABLE reservation ADD CONSTRAINT reservation_reservation_category
    FOREIGN KEY (reservation_category_id)
    REFERENCES reservation_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;






-- End of file.
