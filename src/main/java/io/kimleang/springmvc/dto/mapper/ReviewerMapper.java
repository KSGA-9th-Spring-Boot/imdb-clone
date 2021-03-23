package io.kimleang.springmvc.dto.mapper;

import io.kimleang.springmvc.dto.model.ReviewerDto;
import io.kimleang.springmvc.model.rating.Reviewer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReviewerMapper {
    @Mappings({
            @Mapping(source = "reviewer.id", target = "id"),
            @Mapping(source = "reviewer.username", target = "username")
    })
    ReviewerDto reviewerToReviewerDto(Reviewer reviewer);
    Reviewer reviewerDtoToReviewer(ReviewerDto reviewerDto);
}
