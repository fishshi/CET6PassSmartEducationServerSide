package com.smarteducationserverside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smarteducationserverside.dao.UserAbilityDao;
import com.smarteducationserverside.mapper.UserAbilityMapper;
import com.smarteducationserverside.pojo.UserAbility;

@Repository
public class UserAbilityDaoImpl implements UserAbilityDao {
    @Autowired
    private UserAbilityMapper uAbleMapper;

    @Override
    public UserAbility getUserAbility(String username) {
        return uAbleMapper.getUserAbilityByUsername(username);
    }

    @Override
    public void createUserAbility(UserAbility userAbility) {
        uAbleMapper.insertUserAbility(userAbility);
    }

    @Override
    public void updateUserAbility(UserAbility userAbility) {
        uAbleMapper.updateUserAbility(userAbility);
    }

}
