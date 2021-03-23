package io.kimleang.springmvc.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MovieGenreDto {
    private MovieDto movieDto;
    private GenreDto genreDto;
}
