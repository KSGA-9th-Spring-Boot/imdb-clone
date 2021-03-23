package io.kimleang.springmvc.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WatchListRequest {
    private int userId;
    private int movieId;
}
