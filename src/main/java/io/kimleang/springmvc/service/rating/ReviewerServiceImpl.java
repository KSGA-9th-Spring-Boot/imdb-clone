package io.kimleang.springmvc.service.rating;

import io.kimleang.springmvc.dto.mapper.ReviewerMapper;
import io.kimleang.springmvc.dto.model.ReviewerDto;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.model.rating.Reviewer;
import io.kimleang.springmvc.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Autowired
    private ReviewerMapper reviewerMapper;

    @Override
    public ReviewerDto findReviewerById(Integer id) throws IdNotFoundException {
        Reviewer reviewer = reviewerRepository
                .findReviewerById(id)
                .orElseThrow(() -> new IdNotFoundException("Id Not Found"));
        return reviewerMapper.reviewerToReviewerDto(reviewer);
    }
}
