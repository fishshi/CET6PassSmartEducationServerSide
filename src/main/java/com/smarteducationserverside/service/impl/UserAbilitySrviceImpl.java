package com.smarteducationserverside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarteducationserverside.dao.UserAbilityDao;
import com.smarteducationserverside.pojo.UserAbility;
import com.smarteducationserverside.service.UserAbilityService;

@Service
public class UserAbilitySrviceImpl implements UserAbilityService {
    @Autowired
    private UserAbilityDao uAbleDao;

    @Override
    public UserAbility getUserAbility(String username) {
        return uAbleDao.getUserAbility(username);
    }
}
