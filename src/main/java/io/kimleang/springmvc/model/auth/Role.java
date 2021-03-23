package io.kimleang.springmvc.model.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Role {
    private int id;
    private ERole name = ERole.ROLE_USER;
}
