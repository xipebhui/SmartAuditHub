package com.smartaudithub.dao.repository;

import com.smartaudithub.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * 用户数据访问接口
 *
 * @author claude
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    Optional<User> findByUsername(String username);

    /**
     * 根据用户名或手机号查询用户
     *
     * @param username 用户名
     * @param mobile 手机号
     * @return 用户信息
     */
    Optional<User> findByUsernameOrMobile(String username, String mobile);
} 