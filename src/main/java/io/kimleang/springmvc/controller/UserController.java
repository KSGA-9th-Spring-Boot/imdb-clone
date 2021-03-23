package io.kimleang.springmvc.controller;

import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.exception.IdNotFoundException;
import io.kimleang.springmvc.service.auth.UserDetailsImpl;
import io.kimleang.springmvc.service.user.UserService;
import io.kimleang.springmvc.service.watchlist.WatchListService;
import io.kimleang.springmvc.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WatchListService watchListService;

    @GetMapping("/{id}")
    public String findUserById(@PathVariable Integer id,
                               Model model,
                               @CurrentUser UserDetailsImpl userDetails) {
        try {
            UserDto userDto = userService.findUserById(id);
            List<WatchListDto> watchListDtoList = watchListService.findAllWatchListByUserId(userDto);
            model.addAttribute("user", userDto);
            model.addAttribute("watchLists", watchListDtoList);
            if (userDetails != null) {
                model.addAttribute("isOwner", userDetails.getId() == id);
            } else {
                model.addAttribute("isOwner", false);
            }
        } catch (IdNotFoundException ex) {
            ex.printStackTrace();
        }
        return "users/user-profile";
    }

}
