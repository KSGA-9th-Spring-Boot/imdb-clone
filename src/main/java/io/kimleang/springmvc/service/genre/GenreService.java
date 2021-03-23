package io.kimleang.springmvc.service.genre;

import io.kimleang.springmvc.dto.model.GenreDto;

import java.util.List;

public interface GenreService {
    boolean save(GenreDto genre);
    List<GenreDto> findAll();
    List<GenreDto> findAllByMovieId(Integer movieId);
}
