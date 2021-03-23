package io.kimleang.springmvc.controller.rest;

import io.kimleang.springmvc.model.Movie;
import io.kimleang.springmvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieRestController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public boolean findAllMovies() {
        List<Movie> movies = movieRepository.findAllMovies();
        System.out.println(movies);
        return true;
    }

    @PostMapping("/filter-by-genres")
    public boolean filterByGenres(@RequestBody List<Integer> genreIds) {
        List<Movie> movies = movieRepository.findMoviesByGenres(genreIds);
        System.out.println(movies);
        return true;
    }

}
