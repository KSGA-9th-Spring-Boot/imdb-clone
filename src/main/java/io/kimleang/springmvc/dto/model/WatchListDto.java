package io.kimleang.springmvc.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class WatchListDto {
    private MovieDto movieDto;
    private UserDto userDto;
}
