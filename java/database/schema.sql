BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS user_profile;
DROP TABLE IF EXISTS user_watchlist;
DROP TABLE IF EXISTS user_movie;
DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS user_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS movies;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar (20),
        last_name varchar (40),
        email_address varchar (200),
        phone_number varchar (20),
        social_security_number varchar (10),

	
	
	
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE movies (
        movie_id serial,
        imdb_id varchar (20) not null,
        movie_genre varchar (20) not null,
        movie_title varchar (20) not null,
        movie_description varchar (2000),
        movie_image varchar (1000),
        year_released date not null,
        rating varchar (10),
        movie_length varchar (50),
 
        constraint pk_movie_id primary key (movie_id)
);
   
CREATE TABLE genre (
        genre_id serial,
        genre_name varchar (20),
        
        constraint pk_genre primary key (genre_id)
        
);

CREATE TABLE user_genre (
        user_id int not null,
        genre_id int not null,
        
        constraint pk_user_genre primary key (user_id, genre_id),
        constraint fk_user_id foreign key (user_id) references genre (genre_id),
        constraint fk_genre_id foreign key (genre_id) references users (user_id)
);

CREATE TABLE movie_genre (
        movie_id int not null,
        genre_id int not null,
        
        constraint pk_movie_genre primary key (movie_id, genre_id),
        constraint fk_movie_id foreign key (movie_id) references genre (genre_id),
        constraint fk_genre_id foreign key (genre_id) references movies (movie_id)
);

CREATE TABLE user_movie (
        movie_id int not null,
        user_id int not null,
        user_preference_description varchar (10),
        
        constraint pk_user_movie primary key (movie_id, user_id),
        constraint fk_movie_id foreign key (movie_id) references users (user_id),
        constraint fk_user_id foreign key (user_id) references movies (movie_id)
);

CREATE TABLE user_profile (
        user_id int not null,
        first_name varchar (20),
        last_name varchar (40),
        email_address varchar (200),
        phone_number varchar (20),
        social_security_number varchar (10),
        
        
        constraint fk_user_id foreign key (user_id) references users (user_id)
   
);

        



INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
