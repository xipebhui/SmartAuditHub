CREATE DATABASE smart_audit_hub DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE TABLE `smart_audit_hub`.`sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 0-禁用 1-启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- 插入测试数据（密码均为123456）
INSERT INTO `smart_audit_hub`.`sys_user` VALUES 
(1, 'admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '系统管理员', '13800138000', 'admin@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(2, 'zhangsan', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '张三', '13800138001', 'zhangsan@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(3, 'lisi', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '李四', '13800138002', 'lisi@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(4, 'wangwu', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '王五', '13800138003', 'wangwu@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(5, 'zhaoliu', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '赵六', '13800138004', 'zhaoliu@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(6, 'sunqi', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '孙七', '13800138005', 'sunqi@example.com', 0, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(7, 'zhouba', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '周八', '13800138006', 'zhouba@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(8, 'wujiu', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '吴九', '13800138007', 'wujiu@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(9, 'zhengshi', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '郑十', '13800138008', 'zhengshi@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0),
(10, 'test', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '测试用户', '13800138009', 'test@example.com', 1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 0); 