package io.kimleang.springmvc.service.auth;

import io.kimleang.springmvc.model.auth.User;
import io.kimleang.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with that email " + email + " not found"));
        return UserDetailsImpl.build(user);
    }
}
