package com.bookmyshow.spring.BookMyShow.repository;

import com.bookmyshow.spring.BookMyShow.collectionsTables.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {


    Optional<Movie> findMovieByImdbId(String imdbID);
    Optional<Movie> findReleaseDateByTitle(String title);
    void deleteMovieByTitle(String title);





}
