package com.yedam.app.security.service;

import lombok.Data;

@Data
public class UserVO {
     private String loginId;
     private String passWord;
     private String roleName;
}
