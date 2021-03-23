package io.kimleang.springmvc.repository;

import io.kimleang.springmvc.model.auth.Role;
import io.kimleang.springmvc.model.auth.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM users WHERE email = #{email}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "roles", column = "id", many = @Many(select = "findRolesByUserId"))
    })
    Optional<User> findUserByEmail(String email);

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id")
    })
    Optional<User> findUserById(Integer id);

    @Select("SELECT r.id, r.name FROM roles r INNER JOIN users_roles ur ON r.id = ur.role_id WHERE ur.user_id = #{userId}")
    Set<Role> findRolesByUserId(Integer userId);
}
