package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.genre.Genre;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GenreRepository {
    @Insert("INSERT INTO genres (name) VALUES (#{genre.name})")
    boolean save(@Param("genre") Genre genre);

    @Select("SELECT * FROM genres")
    List<Genre> findAll();

    @Select("SELECT g.id, g.name FROM genres g INNER JOIN movies_genres mg ON g.id = mg.genre_id WHERE mg.movie_id = #{movieId}")
    List<Genre> findAllByMovieId(Integer movieId);
}
