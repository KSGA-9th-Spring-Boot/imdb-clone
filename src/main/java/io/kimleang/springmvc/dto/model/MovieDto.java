package io.kimleang.springmvc.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MovieDto {
    private int id;
    private String title;
    private String description;
    private Date releasedDate;
    private String trailer;
    private int runtime;
    private int numberVotes;
    private String thumbnail;

    private double rate;

    private int year;

    private boolean isWatchListed = false;

    private List<GenreDto> genreDtos = new ArrayList<>();

}
