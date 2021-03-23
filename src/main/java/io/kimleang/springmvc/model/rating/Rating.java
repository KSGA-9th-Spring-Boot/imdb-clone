package io.kimleang.springmvc.model.rating;

import io.kimleang.springmvc.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private int id;
    private int rate;
    private Movie movie;
    private Reviewer reviewer;
}
