package com.ktdsuniversity.edu.member.service;

import com.ktdsuniversity.edu.member.vo.RequestRegistMemberVO;

import jakarta.validation.Valid;

public interface MemberService {

	boolean createNewMember(RequestRegistMemberVO requestRegistMemberVO);

	int readMemberCountByEmail(String email);

}