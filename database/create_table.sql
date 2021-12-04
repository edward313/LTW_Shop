use doanweb;

create table category(
	id bigint primary key auto_increment,
    name varchar(255),
    code varchar(255),
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

create table product(
	id bigint primary key auto_increment,
    name varchar(255) NOT NULL,
    price float NOT NULL,
    thumbnail varchar(255) NULL,
    categoryid bigint NOT NULL,
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

ALTER TABLE product ADD CONSTRAINT fk_product_category FOREIGN KEY (categoryid) REFERENCES category (id);

create table role(
	id bigint primary key auto_increment,
    name varchar(255) NOT NULL,
    code varchar(255) NOT NULL,
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

create table user(
	id bigint primary key,
    username varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    fullname varchar(255) NOT NULL,
    status int NOT NULL,
    roleid bigint NOT NULL,
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role (id);


create table bill(
	id bigint primary key NOT NULL auto_increment,
    userid bigint NOT NULL,
    productid bigint NOT NULL,
    totalprice float NOT NULL,
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

ALTER TABLE bill ADD CONSTRAINT fk_bill_user FOREIGN KEY (userid) REFERENCES user (id);
ALTER TABLE bill ADD CONSTRAINT fk_bill_product FOREIGN KEY (productid) REFERENCES product (id);

create table comment(
	id bigint primary key auto_increment,
    content text NOT NULL,
    userid bigint NOT NULL,
    productid bigint NOT NULL,
    createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (userid) REFERENCES user (id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_product FOREIGN KEY (productid) REFERENCES product (id);


