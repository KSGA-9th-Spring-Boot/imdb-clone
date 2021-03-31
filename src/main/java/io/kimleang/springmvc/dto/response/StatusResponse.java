package io.kimleang.springmvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
@AllArgsConstructor
public class StatusResponse {

    private boolean success;
    private String message;

}
