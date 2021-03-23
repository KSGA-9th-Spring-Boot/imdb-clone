package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.rating.Reviewer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface ReviewerRepository {

    @Select("SELECT * FROM reviewers WHERE id = #{id}")
    Optional<Reviewer> findReviewerById(Integer id);

}
