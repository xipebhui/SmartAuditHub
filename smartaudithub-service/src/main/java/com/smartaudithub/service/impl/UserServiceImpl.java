package com.smartaudithub.service.impl;

import com.smartaudithub.dao.entity.User;
import com.smartaudithub.dao.repository.UserRepository;
import com.smartaudithub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现类
 *
 * @author claude
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user) {
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        User existingUser = getUser(user.getId());
        // 如果密码不为空，则更新密码
        if (user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setRealName(user.getRealName());
        existingUser.setMobile(user.getMobile());
        existingUser.setEmail(user.getEmail());
        existingUser.setStatus(user.getStatus());
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Long id) {
        User user = getUser(id);
        user.setIsDeleted(1);
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    @Override
    public Page<User> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
} 