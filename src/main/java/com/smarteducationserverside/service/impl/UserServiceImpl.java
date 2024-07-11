package com.smarteducationserverside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarteducationserverside.dao.UserAbilityDao;
import com.smarteducationserverside.dao.UserDao;

import com.smarteducationserverside.pojo.RespondUser;
import com.smarteducationserverside.pojo.User;
import com.smarteducationserverside.pojo.UserAbility;
import com.smarteducationserverside.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAbilityDao uAbleDao;

    // @Autowired
    // private EmailUtils emailUtils;

    @Override
    public int login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password))
            return 1;
        return 0;
    }

    @Transactional
    @Override
    public int register(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            userDao.createUser(new User(0, username, password));
            User registeredUser = userDao.getUserByUsername(username);
            uAbleDao.createUserAbility(new UserAbility(registeredUser.getId(), username));
            return 1;
        }
        return 0;
    }

    @Override
    public RespondUser getUser(String username) {
        return userDao.RespondUserByUsername(username);
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        User user = userDao.getUserByUsername(username);
        if (!user.getPassword().equals(oldPassword))
            return 0;
        userDao.updatePassword(username, newPassword);
        return 1;
    }

    @Override
    public int updateUserInfo(RespondUser user, String username) {
        if (user.getUsername() == null || !user.getUsername().equals(username))
            return 0;
        userDao.updateUserInfo(user);
        return 1;
    }

    @Override
    public int updateAvatarUrl(String avatarUrl, String username) {
        RespondUser user = userDao.RespondUserByUsername(username);
        if (user == null || !user.getUsername().equals(username))
            return 0;
        user.setAvatarUrl(avatarUrl);
        userDao.updateAvatarUrl(user);
        return 1;
    }
}