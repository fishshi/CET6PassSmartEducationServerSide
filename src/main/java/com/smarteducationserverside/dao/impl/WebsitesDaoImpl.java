package com.smarteducationserverside.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smarteducationserverside.dao.WebsitesDao;
import com.smarteducationserverside.mapper.WebsitesMapper;
import com.smarteducationserverside.pojo.Website;

@Repository
public class WebsitesDaoImpl implements WebsitesDao {
    @Autowired
    private WebsitesMapper wMapper;

    @Override
    public List<Website> getAllWebsites() {
        return wMapper.getAllWebsites();
    }

}
