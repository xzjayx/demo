package com.xz.demo.service;

import com.xz.demo.dao.AdminMapper;
import com.xz.demo.model.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private AdminMapper mapper;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public Admin selectOne(Admin admin){
        return mapper.selectOne(admin);
    }
}
