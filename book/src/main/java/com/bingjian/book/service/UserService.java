package com.bingjian.book.service;


import java.util.Collection;

import com.bingjian.book.domain.User;
import com.bingjian.book.domain.UserCreateForm;

/**
 * @author Myazure
 */
public interface UserService {

    User getUserById(long id);

    User getUserByName(String name);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
