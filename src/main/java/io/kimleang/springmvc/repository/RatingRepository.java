package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.rating.Rating;
import io.kimleang.springmvc.model.rating.RatingCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RatingRepository {
    @Insert("INSERT INTO ratings (movie_id, reviewer_id, rate) VALUES (#{rating.movie.id}, #{rating.reviewer.id}, #{rating.rate})")
    boolean rate(@Param("rating") Rating rating);

    @Select("SELECT rate, count(rate) FROM ratings  WHERE movie_id = #{movieId} GROUP BY rate ORDER BY rate DESC")
    @Results({
            @Result(property = "rate", column = "rate"),
            @Result(property = "count", column = "count")
    })
    List<RatingCount> findAllRateAndCountByMovieId(Integer movieId);
}
