package com.bingjian.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bingjian.book.domain.User;
import com.bingjian.book.domain.UserCreateForm;
import com.bingjian.book.repository.UserRepository;

import java.util.Collection;

/**
 * @author Myazure
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public User getUserByName(String name) {
        return userRepository.findOneByUserName(name);
    }

    public Collection<User> getAllUsers() {
        return (Collection<User>) userRepository.findAll(new Sort("userName"));
    }

    public User create(UserCreateForm form) {
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

}
