package com.bingjian.book.service.currentUser;

import com.bingjian.book.domain.CurrentUser;


/**
 * @author Myazure
 */
public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
