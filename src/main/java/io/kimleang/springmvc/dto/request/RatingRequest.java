package io.kimleang.springmvc.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RatingRequest {
    private int movieId;
    private int reviewerId;
    private int rate;
}
