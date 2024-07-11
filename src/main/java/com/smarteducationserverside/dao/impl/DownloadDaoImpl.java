package com.smarteducationserverside.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smarteducationserverside.dao.DownloadDao;
import com.smarteducationserverside.mapper.DownloadMapper;
import com.smarteducationserverside.pojo.Download;

@Repository
public class DownloadDaoImpl implements DownloadDao {
    @Autowired
    private DownloadMapper downloadMapper;

    @Override
    public List<Download> getDownloadList() {
        return downloadMapper.getDownloadList();
    }

}
