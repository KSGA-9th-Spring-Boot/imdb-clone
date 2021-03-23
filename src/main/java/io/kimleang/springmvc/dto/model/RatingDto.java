package io.kimleang.springmvc.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class RatingDto {
    private int id;
    private int rate;
    private MovieDto movieDto;
    private ReviewerDto reviewerDto;
}
