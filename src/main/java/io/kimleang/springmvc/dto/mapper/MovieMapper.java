package io.kimleang.springmvc.dto.mapper;

import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "year", expression = "java(MovieMapper.splitYearFromDate(movie.getReleasedDate()))")
    @Mapping(source = "rate", target = "rate")
    MovieDto movieToMovieDto(Movie movie);

    @Mapping(source = "rate", target = "rate")
    Movie movieDtoToMovie(MovieDto movieDto);

    List<Movie> movieDtosToMovies(List<MovieDto> movieDtos);
    @Mapping(source = "rate", target = "rate")
    List<MovieDto> moviesToMovieDtos(List<Movie> movies);

    static int splitYearFromDate(Date date) {
        try {
            String pattern = "MM-dd-yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            String formatted = dateFormat.format(date);
            return Integer.parseInt(formatted.split("-")[2]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
