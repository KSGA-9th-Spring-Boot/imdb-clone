package io.kimleang.springmvc.service.rating;

import io.kimleang.springmvc.dto.model.ReviewerDto;
import io.kimleang.springmvc.exception.IdNotFoundException;

public interface ReviewerService {
    ReviewerDto findReviewerById(Integer id) throws IdNotFoundException;
}
