package com.yedam.app.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;
import com.yedam.app.security.service.LoginUserVO;
import com.yedam.app.security.service.UserVO;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	private UserMapper userMapper;
	
	@Autowired
	CustomerUserDetailsService(UserMapper userMapper){
		this.userMapper = userMapper;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //userdetails는 db에 해당 id의 여부만 체크(비교는 provider)
		// Mapper를 활용해서 DB에 접근
		UserVO userVO = userMapper.getUserInfo(username);
		
		if(userVO == null) { //검색을 했는데 있냐 없냐
			throw new UsernameNotFoundException(username);
		}
		
		return new LoginUserVO(userVO); //검색이 되었으면 LoginUserVO이 형태로 리턴
	}

}
