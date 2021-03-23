package io.kimleang.springmvc.controller;

import io.kimleang.springmvc.dto.mapper.UserMapper;
import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.model.auth.User;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.movie.MovieService;
import io.kimleang.springmvc.service.user.UserService;
import io.kimleang.springmvc.service.watchlist.WatchListService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private WatchListService watchListService;

    @GetMapping({"/", "/movies"})
    public String findAllMovies(Model model, @CurrentUser UserDetailsImpl userDetails) throws IdNotFoundException {
        List<MovieDto> movieDtos = movieService.findAllMovies();

        if(userDetails != null) {
            UserDto userDto = userService.findUserById(userDetails.getId());
            List<WatchListDto> watchListDtos = watchListService.findAllWatchListByUserId(userDto);

            movieDtos = movieDtos.stream().peek(movieDto -> {
                for (WatchListDto watchListDto : watchListDtos) {
                    if(movieDto.getId() == watchListDto.getMovieDto().getId()) {
                        movieDto.setWatchListed(true);
                    }
                }
            }).collect(Collectors.toList());
        }

        model.addAttribute("movies", movieDtos);

        return "index";
    }

    @GetMapping("/movies/{id}")
    public String findAllMovies(@PathVariable Integer id, Model model) throws IdNotFoundException {
        MovieDto movie = movieService.findMovieById(id);
        model.addAttribute("movie", movie);
        return "movies/view";
    }

}
