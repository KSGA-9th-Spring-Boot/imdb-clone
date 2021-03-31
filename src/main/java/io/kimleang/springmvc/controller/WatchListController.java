package io.kimleang.springmvc.controller;

import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.dto.request.WatchListRequest;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.movie.MovieService;
import io.kimleang.springmvc.service.user.UserService;
import io.kimleang.springmvc.service.watchlist.WatchListService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/watchlists")
public class WatchListController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private WatchListService  watchListService;

    @PostMapping("/add")
    public String addToWatchLists(@ModelAttribute WatchListRequest watchListRequest,
                                  @CurrentUser UserDetailsImpl userDetails) throws IdNotFoundException {
        try {
            System.out.println(watchListRequest);
            MovieDto movieDto = movieService.findMovieById(watchListRequest.getMovieId());
            UserDto userDto = userService.findUserById(userDetails.getId());
            WatchListDto watchListDto = new WatchListDto()
                    .setMovieDto(movieDto)
                    .setUserDto(userDto);
            boolean saved = watchListService.save(watchListDto);
            System.out.println("========> " + saved);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String removeFromWatchLists(@ModelAttribute WatchListRequest watchListRequest) throws IdNotFoundException {
        try {
            System.out.println(watchListRequest);
            MovieDto movieDto = movieService.findMovieById(watchListRequest.getMovieId());
            UserDto userDto = userService.findUserById(watchListRequest.getUserId());
            WatchListDto watchListDto = new WatchListDto()
                    .setMovieDto(movieDto)
                    .setUserDto(userDto);
            boolean deleted = watchListService.delete(watchListDto);
            System.out.println("========> " + deleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
