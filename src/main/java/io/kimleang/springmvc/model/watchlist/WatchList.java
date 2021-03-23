package io.kimleang.springmvc.model.watchlist;

import io.kimleang.springmvc.model.Movie;
import io.kimleang.springmvc.model.auth.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WatchList {
    private User user;
    private Movie movie;
}
