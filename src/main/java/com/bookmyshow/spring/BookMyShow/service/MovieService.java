package com.bookmyshow.spring.BookMyShow.service;

import com.bookmyshow.spring.BookMyShow.collectionsTables.Movie;
import com.bookmyshow.spring.BookMyShow.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }
    public void deleteMovieById(ObjectId deleteId)
    {
        movieRepository.deleteById(deleteId);
    }
    public  void deleteMovieByTitle(String title)
    {
        movieRepository.deleteMovieByTitle(title);
    }

   public Optional<Movie> singleMovie(ObjectId unique)
    {
       return movieRepository.findById(unique);
    }
    public Optional<Movie> getMovieByImdbID(String imdbID)
    {
        return movieRepository.findMovieByImdbId(imdbID);
    }

    public Optional<Movie> getReleaseDateByTitle(String tile)
    {
return movieRepository.findReleaseDateByTitle(tile);
    }

    public Movie createNewMovie(Movie movie)
    {
        return movieRepository.save(movie);

    }
}
