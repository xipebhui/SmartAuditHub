package com.smartaudithub.dao.entity;

import com.smartaudithub.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 用户实体
 *
 * @author claude
 */
@Data
@Entity
@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false, length = 100)
    private String password;

    /**
     * 真实姓名
     */
    @Column(length = 50)
    private String realName;

    /**
     * 手机号
     */
    @Column(length = 11)
    private String mobile;

    /**
     * 邮箱
     */
    @Column(length = 100)
    private String email;

    /**
     * 状态 0-禁用 1-启用
     */
    private Integer status = 1;
} 