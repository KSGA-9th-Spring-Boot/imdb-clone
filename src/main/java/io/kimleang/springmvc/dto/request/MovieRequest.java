package io.kimleang.springmvc.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MovieRequest {
    private String title;
    private String description;
    private Date releasedDate;
    private String trailer;
    private int runtime;
    private String thumbnail;
}
