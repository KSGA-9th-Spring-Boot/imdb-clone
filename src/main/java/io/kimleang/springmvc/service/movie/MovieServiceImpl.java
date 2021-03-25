package io.kimleang.springmvc.service.movie;

import io.kimleang.springmvc.dto.mapper.MovieMapper;
import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.model.Movie;
import io.kimleang.springmvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public boolean save(MovieDto movieDto) {
        Movie movie = movieMapper.movieDtoToMovie(movieDto);
        return movieRepository.save(movie);
    }

    @Override
    public MovieDto findMovieById(Integer id) throws IdNotFoundException {
        Movie movie = movieRepository
                .findMovieById(id)
                .orElseThrow(() -> new IdNotFoundException("Id Not Found"));
        return movieMapper.movieToMovieDto(movie);
    }

    @Override
    public List<MovieDto> findMoviesByGenres(List<Integer> genres) {
        List<Movie> movies = movieRepository.findMoviesByGenres(genres);
        return movieMapper.moviesToMovieDtos(movies);
    }

    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> movies = movieRepository.findAllMovies();
        return movieMapper.moviesToMovieDtos(movies);
    }

}
