DROP TABLE IF EXISTS user_watchlist;
DROP TABLE IF EXISTS user_movie;
DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS user_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS movies;


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

        

