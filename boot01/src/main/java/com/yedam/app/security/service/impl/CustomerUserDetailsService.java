package com.yedam.app.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service//처음 서비스부터 먼저 구현
public class CustomerUserDetailsService implements UserDetailsService{
    private UserMapper userMapper;
    
    CustomerDetailsService(UserMapper userMapper){
    	this.userMapper =userMapper;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws
	//Mapper를 활용해서 DB에 접근
	UserVO userVO = userMapper.getUserInfo(username);
	
	if (userVO==null) {
		throw new UsernameNotFoundException(username);
	}
	return new LoginUserVO(userVO);
}
