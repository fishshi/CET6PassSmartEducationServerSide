package com.smarteducationserverside.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarteducationserverside.dao.DownloadDao;
import com.smarteducationserverside.pojo.Download;
import com.smarteducationserverside.service.DownloadService;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Autowired
    private DownloadDao downloadDao;

    @Override
    public List<Download> getDownloadList() {
        return downloadDao.getDownloadList();
    }

}
