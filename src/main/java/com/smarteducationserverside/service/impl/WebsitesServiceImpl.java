package com.smarteducationserverside.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarteducationserverside.dao.WebsitesDao;
import com.smarteducationserverside.pojo.Website;
import com.smarteducationserverside.service.WebsitesService;

@Service
public class WebsitesServiceImpl implements WebsitesService {
    @Autowired
    private WebsitesDao wDao;

    @Override
    public List<Website> getAllWebsites() {
        return wDao.getAllWebsites();
    }

}
