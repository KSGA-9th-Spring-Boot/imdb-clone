package io.kimleang.springmvc.repository.provider;

import io.kimleang.springmvc.model.genre.Genre;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class MovieProvider {
    public String findAllMoviesByGenres(@Param("genres") List<Integer> genres) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("movies m");
            INNER_JOIN("movies_genres mg ON m.id = mg.movie_id");
            WHERE("mg.genre_id IN ("
                    + "<foreach item='genre' collection='genres' separator=','>"
                    + "#{genre}"
                    + "</foreach>"
                    + ")"
            );
        }}.toString();
        return "<script>" + sql + "</script>";
    }
}
