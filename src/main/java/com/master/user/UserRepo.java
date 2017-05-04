package com.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
public interface UserRepo extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

 /*   @Query(" from User u where u.username=:username and u.password=:password ")
    User findUser(@Param("username") String username,@Param("password") String password);*/

    @Query( " from User u where u.username=:username")
    User findUserByUsername(@Param("username") String username);
}
