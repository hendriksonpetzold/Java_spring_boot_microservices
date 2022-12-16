CREATE TABLE payment (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 payment_value decimal(19,2) NOT NULL,
 name varchar(100) DEFAULT NULL,
 number varchar(19) DEFAULT NULL,
 expiration varchar(7) DEFAULT NULL,
 code varchar(3) DEFAULT NULL,
 status varchar(255) NOT NULL,
 way_to_payment_id bigint(20) NOT NULL,
 request_id bigint(20) NOT NULL,
 PRIMARY KEY (id)
);