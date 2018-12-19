package com.bingjian.book.service.currentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bingjian.book.domain.CurrentUser;
import com.bingjian.book.domain.User;
import com.bingjian.book.service.UserService;

/**
 * @author Myazure
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.getUserByName(name);
        if(user == null) {
            throw new UsernameNotFoundException(name + " not found");
        }
        return new CurrentUser(user);
    }
}
