package io.kimleang.springmvc.service.rating;

import io.kimleang.springmvc.dto.model.RatingDto;

public interface RatingService {
    boolean rate(RatingDto ratingDto);
}
