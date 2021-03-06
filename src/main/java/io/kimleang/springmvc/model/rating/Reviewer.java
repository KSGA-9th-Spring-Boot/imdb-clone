package io.kimleang.springmvc.model.rating;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Reviewer {
    private int id;
    private String username;
    private List<Rating> ratings = new ArrayList<>();
}
