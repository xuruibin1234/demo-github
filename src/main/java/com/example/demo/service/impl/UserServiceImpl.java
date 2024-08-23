package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.demo.common.enums.UserErrorEnums;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuruibin
 * @since 2024-08-22
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable
    @Override
    public User findUserById(Long userid) {
        User selectById = userMapper.selectById(userid);
        return selectById;
    }

    @CachePut(key = "#user.id")
    @Override
    public UserDto updateUserById(User user) {
        UserDto result = new UserDto();
        // 更新数据库中的书籍信息
        boolean updated = lambdaUpdate()
                .set(User::getName, user.getName())
                .set(User::getAge, user.getAge())
                .set(User::getEmail, user.getEmail())
                .eq(User::getId, user.getId()).update();
        if (updated) {
            User updatedAndFindUserById = findUserById(user.getId());
            result.setId(updatedAndFindUserById.getId());
            result.setName(updatedAndFindUserById.getName());
            result.setAge(updatedAndFindUserById.getAge());
            result.setEmail(updatedAndFindUserById.getEmail());
            return result;
        }
        result.setErrorMsg(UserErrorEnums.param_error_id.getErrormsg());
        return result;
    }

    //    @CacheEvict(key = "#isbn")
//    public void deleteBook(ISBN isbn) {
//        // 从数据库中删除书籍
//        deleteBookFromDatabase(isbn);
//        // 并从缓存中移除对应的书籍信息
//    }
}
