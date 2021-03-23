package io.kimleang.springmvc.model;

import io.kimleang.springmvc.model.genre.Genre;
import io.kimleang.springmvc.model.keyword.Keyword;
import io.kimleang.springmvc.model.rating.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String description;
    private Date releasedDate;
    private String trailer;
    private int runtime;
    private int numberVotes;
    private String thumbnail;

    private double rate;

    private List<Rating> ratings = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<Keyword> keywords = new ArrayList<>();
}
