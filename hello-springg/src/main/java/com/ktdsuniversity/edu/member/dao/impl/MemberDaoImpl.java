package com.ktdsuniversity.edu.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.member.dao.MemberDao;
import com.ktdsuniversity.edu.member.vo.RequestRegistMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

    private final String NAME_SPACE = "com.ktdsuniversity.edu.member.dao.impl.MemberDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertNewMember(RequestRegistMemberVO requestRegistMemberVO) {
		return super.getSqlSession().insert(this.NAME_SPACE + "insertNewMember", requestRegistMemberVO);
	}

	@Override
	public int selectMemberCountByEmail(String email) {
		// count니까 selectOne
		return super.getSqlSession().selectOne(this.NAME_SPACE + "selectMemberCountByEmail", email);
	}


}