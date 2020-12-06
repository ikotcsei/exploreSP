create table users(
    id SERIAL PRIMARY KEY,
	username varchar(50) not null UNIQUE,
	password varchar(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);


INSERT INTO users(username, password, enabled) VALUES('user', 'user', true);
INSERT INTO users(username, password, enabled) VALUES('admin', 'admin', true);
INSERT INTO users(username, password, enabled) VALUES('feri', 'user', true);
INSERT INTO users(username, password, enabled) VALUES('sanyi', 'user', true);

INSERT INTO authorities(username, authority) VALUES('sanyi','ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('feri','ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('user','ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('admin','ROLE_ADMIN');
