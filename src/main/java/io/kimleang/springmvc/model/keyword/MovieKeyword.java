package io.kimleang.springmvc.model.keyword;

import io.kimleang.springmvc.model.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieKeyword {

    private Movie movie;
    private Keyword keyword;

}
