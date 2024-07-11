package com.smarteducationserverside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smarteducationserverside.dao.UserDao;
import com.smarteducationserverside.mapper.UserMapper;
import com.smarteducationserverside.pojo.RespondUser;
import com.smarteducationserverside.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.SelectByUsername(username);
    }

    @Override
    public RespondUser RespondUserByUsername(String username) {
        return userMapper.RespondByUsername(username);
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        userMapper.updatePassword(username, newPassword);
    }

    @Override
    public void updateUserInfo(RespondUser user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateAvatarUrl(RespondUser user) {
        userMapper.updateAvatarUrl(user);
    }
}
