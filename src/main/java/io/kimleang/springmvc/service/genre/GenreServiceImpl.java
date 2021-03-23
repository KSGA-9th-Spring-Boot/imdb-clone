package io.kimleang.springmvc.service.genre;

import io.kimleang.springmvc.dto.model.GenreDto;
import io.kimleang.springmvc.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public boolean save(GenreDto genre) {
        return false;
    }

    @Override
    public List<GenreDto> findAll() {
        return null;
    }

    @Override
    public List<GenreDto> findAllByMovieId(Integer movieId) {
        return null;
    }
}
