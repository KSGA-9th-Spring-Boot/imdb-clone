package io.kimleang.springmvc.controller.rest;

import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.dto.model.RatingDto;
import io.kimleang.springmvc.dto.model.ReviewerDto;
import io.kimleang.springmvc.dto.request.RatingRequest;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.movie.MovieService;
import io.kimleang.springmvc.service.rating.RatingService;
import io.kimleang.springmvc.service.rating.ReviewerService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingRestController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewerService reviewerService;

    @PostMapping("/rate")
    public boolean rate(@RequestBody RatingRequest ratingRequest, @CurrentUser UserDetailsImpl userDetails) {
        System.out.println(ratingRequest.toString());
        System.out.println(userDetails.toString());
        try {
            MovieDto movieDto = movieService.findMovieById(ratingRequest.getMovieId());
            ReviewerDto reviewerDto = reviewerService.findReviewerById(ratingRequest.getReviewerId());
            if (movieDto == null || reviewerDto == null) {
                return false;
            }
            RatingDto ratingDto = new RatingDto()
                    .setMovieDto(movieDto)
                    .setReviewerDto(reviewerDto)
                    .setRate(ratingRequest.getRate());
            boolean saved = ratingService.rate(ratingDto);
            if(saved) {
                System.out.println("You vote");
                return true;
            }
        } catch (IdNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
