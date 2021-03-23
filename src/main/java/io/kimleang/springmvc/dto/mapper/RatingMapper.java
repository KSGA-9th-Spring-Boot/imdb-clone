package io.kimleang.springmvc.dto.mapper;

import io.kimleang.springmvc.dto.model.RatingDto;
import io.kimleang.springmvc.model.rating.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingDto ratingToRatingDto(Rating rating);

    @Mappings({
            @Mapping(source = "movieDto", target = "movie"),
            @Mapping(source = "reviewerDto", target = "reviewer")
    })
    Rating ratingDtoToRating(RatingDto ratingDto);
}
