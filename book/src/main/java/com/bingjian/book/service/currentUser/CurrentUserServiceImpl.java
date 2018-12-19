package com.bingjian.book.service.currentUser;

import com.bingjian.book.domain.CurrentUser;
import com.bingjian.book.domain.Role;


/**
 * @author Myazure
 */
public class CurrentUserServiceImpl implements CurrentUserService {

    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }
}
