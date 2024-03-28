package com.bookmyshow.spring.BookMyShow.controller;

import com.bookmyshow.spring.BookMyShow.collectionsTables.Movie;
import com.bookmyshow.spring.BookMyShow.service.MovieService;
import com.mongodb.internal.VisibleForTesting;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
/*@RequestMapping("/api/v1/movies")*/
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value="/")
    public void loadSwaggerUI(HttpServletResponse response)
    {
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (IOException exception123) {
            throw new RuntimeException(exception123);
        }
    }
    @GetMapping("/api/v1/movies")
    public ResponseEntity<List<Movie>> allMovies()
    {
        return new ResponseEntity<List<Movie>>( movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{unique}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId unique)
    {
            return new ResponseEntity<>(movieService.singleMovie(unique),HttpStatus.OK);
    }

    @GetMapping("/Imdb/{imdbID}")
    public ResponseEntity<Optional<Movie>> getMovieBasedOnImdbID(@PathVariable String imdbID)
    {
        return new ResponseEntity<>(movieService.getMovieByImdbID(imdbID),HttpStatus.OK);
    }

    @GetMapping("/tile/{title}")
    public ResponseEntity<Optional<Movie>> getReleaseDate(@PathVariable String title)
    {
        return    new ResponseEntity<Optional<Movie>>(movieService.getReleaseDateByTitle(title),HttpStatus.OK);
    }

    @DeleteMapping("/movie/title/{title}")
  public  ResponseEntity<String> deleteMovieByTitle(@PathVariable String title)
    {
        movieService.deleteMovieByTitle(title);
        return ResponseEntity.ok("Movie has been deleted by title");
    }

    public ResponseEntity<String> deleteMovieById(ObjectId movieId)
    {
        movieService.deleteMovieById(movieId);
       return ResponseEntity.ok("Movie is deleted successfully");
    }

    @DeleteMapping("/movie/{movieID}")
    public void deleteMovie(@PathVariable ObjectId movieID)
    {
        ResponseEntity<String> stringResponseEntity = deleteMovieById(movieID);
    }

    @PostMapping(value = "/addMovie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie)
    {
movieService.createNewMovie(movie);
        return ResponseEntity.ok("New Movie is created successfully");
    }
}
