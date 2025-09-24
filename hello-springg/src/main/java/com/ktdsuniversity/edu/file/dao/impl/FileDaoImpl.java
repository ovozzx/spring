package com.ktdsuniversity.edu.file.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.file.dao.FileDao;

@Repository
public class FileDaoImpl extends SqlSessionDaoSupport implements FileDao {

    private final String NAME_SPACE = "com.ktdsuniversity.edu.file.dao.impl.FileDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }


}