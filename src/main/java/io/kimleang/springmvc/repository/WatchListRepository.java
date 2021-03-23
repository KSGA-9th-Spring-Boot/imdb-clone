package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.Movie;
import io.kimleang.springmvc.model.watchlist.WatchList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WatchListRepository {
    @Insert("INSERT INTO watchlists VALUES (#{movieId}, #{userId})")
    boolean save(@Param("movieId") Integer movieId, @Param("userId") Integer userId);

    @Delete("DELETE FROM watchlists WHERE movie_id = #{movieId} AND user_id = #{userId}")
    boolean delete(@Param("movieId") Integer movieId, @Param("userId") Integer userId);

    @Select("SELECT * FROM watchlists WHERE user_id = #{userId}")
    @Results({
            @Result(property = "movie", column = "movie_id", one = @One(select = "findMovieById"))
    })
    List<WatchList> findAllWatchListByUserId(Integer userId);

    @Select("SELECT * FROM movies WHERE id = #{id}")
    @Results({
            @Result(property = "releasedDate", column = "released_date"),
            @Result(property = "numberVotes", column = "number_votes")
    })
    Movie findMovieById(Integer id);
}
