package com.bingjian.book.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bingjian.book.domain.User;


/**
 * @author Myazure
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findOneByUserName(String userName);
}
