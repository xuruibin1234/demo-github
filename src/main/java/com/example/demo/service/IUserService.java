package com.example.demo.service;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.dto.UserDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuruibin
 * @since 2024-08-22
 */
public interface IUserService extends IService<User> {

    public UserDto updateUserById(User user);

    public User findUserById(Long userid);

}
