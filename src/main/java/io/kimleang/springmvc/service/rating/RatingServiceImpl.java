package io.kimleang.springmvc.service.rating;

import io.kimleang.springmvc.dto.mapper.RatingMapper;
import io.kimleang.springmvc.dto.model.RatingDto;
import io.kimleang.springmvc.model.rating.Rating;
import io.kimleang.springmvc.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public boolean rate(RatingDto ratingDto) {
        Rating rating = ratingMapper.ratingDtoToRating(ratingDto);
        return ratingRepository.rate(rating);
    }
}
