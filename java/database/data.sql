DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS user_genre;
DROP TABLE IF EXISTS movie_genre;



CREATE TABLE users (
        user_id serial,
        username varchar (50) not null,
        password_hash varchar (200) not null,
        role varchar (50) not null,
        first_name varchar (20),
        last_name varchar (40),
        email_address varchar (200),
        phone_number varchar (20),
        social_security_number varchar (10),
        
        constraint pk_userId primary key (user_id)
);



CREATE TABLE movies (
        movie_id serial,
        imbd_id varchar (20) not null,
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
        
        constraint pk_genres primary key (genre_id)
        

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
        constraint fk_genre_id foreign key (genre_id) references users (user_id)
);     
        

