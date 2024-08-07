package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Bean 등록, Web과 관련된 부분 처리
public class URLController {
  //@RequestMapping(path = "/test", method=RequestMethod.GET )
  @GetMapping("/test")
  @ResponseBody//아작스 전용 컨트롤러 만들때 사용(특정 페이지가 아닌 컨트롤러를 돌릴수 있음.)
  public String urlCetTest(String keyword) {
	  return "Server Reponse : Get Method\n Select - " + keyword;
  }//urlCetTest end
  
  //@RequestMapping(path="/test", method=RequestMethod.POST)
  @PostMapping("/test")//메서드와 url을 혼합해서 매핑하기 때문에 경로가 같다고 해도 다른걸로 인식
  @ResponseBody
  public String urlPostTest(String keyword) {
	  return "Server Reponse : Post Method\n Select - " + keyword;
  }//urlPostTest end
  
}//URLController end
