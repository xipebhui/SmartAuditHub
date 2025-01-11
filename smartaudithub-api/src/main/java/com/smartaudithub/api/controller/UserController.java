package com.smartaudithub.api.controller;

import com.smartaudithub.common.response.Result;
import com.smartaudithub.dao.entity.User;
import com.smartaudithub.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户管理接口
 *
 * @author claude
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation("创建用户")
    @PostMapping
    public Result<User> createUser(@Valid @RequestBody User user) {
        return Result.success(userService.createUser(user));
    }

    @ApiOperation("更新用户")
    @PutMapping("/{id}")
    public Result<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        return Result.success(userService.updateUser(user));
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return Result.success(null);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        return Result.success(userService.getUser(id));
    }

    @ApiOperation("分页查询用户")
    @GetMapping
    public Result<Page<User>> listUsers(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return Result.success(userService.listUsers(PageRequest.of(page - 1, size)));
    }
} 