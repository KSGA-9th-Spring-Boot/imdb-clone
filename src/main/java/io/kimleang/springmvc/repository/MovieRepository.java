package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.Movie;
import io.kimleang.springmvc.model.genre.Genre;
import io.kimleang.springmvc.repository.provider.MovieProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieRepository {
    @Insert("INSERT INTO movies (title, description, released_date, trailer, runtime, number_votes) " +
            "VALUES (#{movie.title}, #{movie.description}, #{movie.releasedDate}, #{movie.trailer}, #{movie.runtime}, #{movie.numberVotes})")
    boolean save(Movie movie);

    @Select("SELECT m.*, ROUND(AVG(r.rate), 1) rate, COUNT(r.id) reviewers FROM movies m LEFT JOIN ratings r ON m.id = r.movie_id WHERE m.id = #{id} GROUP BY m.id")
    @Results({
            @Result(property = "releasedDate", column = "released_date"),
            @Result(property = "numberVotes", column = "reviewers")
    })
    Optional<Movie> findMovieById(Integer id);

    @Select("SELECT m.*, ROUND(AVG(r.rate), 1) rate, COUNT(r.id) reviewers FROM movies m LEFT JOIN ratings r ON m.id = r.movie_id GROUP BY m.id")
    @Results({
            @Result(property = "releasedDate", column = "released_date"),
            @Result(property = "numberVotes", column = "reviewers")
    })
    List<Movie> findAllMovies();

    @SelectProvider(method = "findAllMoviesByGenres", type = MovieProvider.class)
    @Results({
            @Result(property = "releasedDate", column = "released_date"),
            @Result(property = "numberVotes", column = "number_votes")
    })
    List<Movie> findMoviesByGenres(@Param("genres") List<Integer> genres);
}
