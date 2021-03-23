package io.kimleang.springmvc.model.genre;

import io.kimleang.springmvc.model.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieGenre {

    private Movie movie;
    private Genre genre;

}
