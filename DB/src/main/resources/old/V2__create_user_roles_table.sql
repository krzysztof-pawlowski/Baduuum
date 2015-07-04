CREATE TABLE "users"
(
  "name" character varying(50),
  pass character varying(50)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "users" OWNER TO baduuum;

CREATE TABLE user_roles
(
  user_name character varying(50),
  role_name character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_roles OWNER TO baduuum;
