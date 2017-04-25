package com.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
public interface UserRepo extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
