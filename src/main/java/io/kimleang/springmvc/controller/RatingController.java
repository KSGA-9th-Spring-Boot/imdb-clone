package io.kimleang.springmvc.controller;

import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.dto.model.RatingDto;
import io.kimleang.springmvc.dto.model.ReviewerDto;
import io.kimleang.springmvc.dto.request.RatingRequest;
import io.kimleang.springmvc.dto.response.StatusResponse;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.movie.MovieService;
import io.kimleang.springmvc.service.rating.RatingService;
import io.kimleang.springmvc.service.rating.ReviewerService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewerService reviewerService;

    @PostMapping()
    public RedirectView rateMovie(RatingRequest ratingRequest,
                                  @CurrentUser UserDetailsImpl userDetails,
                                  RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView("/", true);
        try {
            if (userDetails != null) {
                ratingRequest.setReviewerId(userDetails.getId());
            }
            MovieDto movieDto = movieService.findMovieById(ratingRequest.getMovieId());
            ReviewerDto reviewerDto = reviewerService.findReviewerById(ratingRequest.getReviewerId());
            if (movieDto == null || reviewerDto == null) {
                System.out.println("MovieDto or ReviewerDto Not Found");
                return redirectView;
            }
            RatingDto ratingDto = new RatingDto()
                    .setMovieDto(movieDto)
                    .setReviewerDto(reviewerDto)
                    .setRate(ratingRequest.getRate());
            boolean saved = ratingService.rate(ratingDto);

            StatusResponse statusResponse = new StatusResponse(saved, "You rated successfully.");

            redirectAttributes.addFlashAttribute("status", statusResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return redirectView;
    }

}
