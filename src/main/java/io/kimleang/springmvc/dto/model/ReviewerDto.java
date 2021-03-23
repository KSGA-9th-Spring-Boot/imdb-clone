package io.kimleang.springmvc.dto.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ReviewerDto {
    private int id;
    private String username;
    private List<RatingDto> ratings = new ArrayList<>();
}
