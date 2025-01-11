package com.smartaudithub.service;

import com.smartaudithub.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户服务接口
 *
 * @author claude
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return 创建后的用户信息
     */
    User createUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 更新后的用户信息
     */
    User updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Long id);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    User getUser(Long id);

    /**
     * 分页查询用户
     *
     * @param pageable 分页参数
     * @return 用户分页数据
     */
    Page<User> listUsers(Pageable pageable);
} 