package io.kimleang.springmvc.service.movie;

import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.exception.IdNotFoundException;

import java.util.List;

public interface MovieService {
    MovieDto findMovieById(Integer id) throws IdNotFoundException;
    List<MovieDto> findMoviesByGenres(List<Integer> genres);
    List<MovieDto> findAllMovies();
}
