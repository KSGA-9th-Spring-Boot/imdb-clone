package io.kimleang.springmvc.model.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
