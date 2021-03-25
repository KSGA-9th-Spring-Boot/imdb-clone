package io.kimleang.springmvc.controller;

import io.kimleang.springmvc.dto.mapper.MovieMapper;
import io.kimleang.springmvc.dto.model.MovieDto;
import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.dto.request.MovieRequest;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.service.FileStorageService;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.movie.MovieService;
import io.kimleang.springmvc.service.user.UserService;
import io.kimleang.springmvc.service.watchlist.WatchListService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping({"/", "/movies"})
    public String findAllMovies(Model model, @CurrentUser UserDetailsImpl userDetails) throws IdNotFoundException {
        List<MovieDto> movieDtos = movieService.findAllMovies();

        if (userDetails != null) {
            UserDto userDto = userService.findUserById(userDetails.getId());
            List<WatchListDto> watchListDtos = watchListService.findAllWatchListByUserId(userDto);

            movieDtos = movieDtos.stream().peek(movieDto -> {
                for (WatchListDto watchListDto : watchListDtos) {
                    if (movieDto.getId() == watchListDto.getMovieDto().getId()) {
                        movieDto.setWatchListed(true);
                    }
                }
            }).collect(Collectors.toList());
        }

        model.addAttribute("movies", movieDtos);

        return "index";
    }

    @GetMapping("/movies/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new MovieRequest());
        return "movies/add";
    }

    @PostMapping("/movies/add")
    public String addMovie(@ModelAttribute @Valid MovieRequest movieRequest,
                           BindingResult result,
                           Model model) {
        if(result.hasErrors()) {
            return "movies/add";
        }
        movieRequest.setThumbnail("/files/" + movieRequest.getThumbnail());
        MovieDto movieDto = movieMapper.movieRequestToMovieDto(movieRequest);
        movieService.save(movieDto);
        return "redirect:/";
    }

    @GetMapping("/movies/{id}")
    public String findAllMovies(@PathVariable Integer id, Model model) throws IdNotFoundException {
        MovieDto movie = movieService.findMovieById(id);
        model.addAttribute("movie", movie);
        return "movies/view";
    }

}
