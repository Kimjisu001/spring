package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean //비밀번호 암호화
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    //인증 및 인가
    //빈을 새롭게 커스터마이징
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests((authorize) 
    		   ->authorize
    		   .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() //FORWARD해당 통신이 발생했을때 permitAll 인증받지 않은 모든 사람에게 오픈
    		   .requestMatchers("/","/all").permitAll() //인증 없음 손님들이 올수 있는 로비 같은 거라고 볼수 있음.
    		   .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")//hasRole과 hasAuthority는 같은 기능
    		   .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")//다만 hasAuthority는 ROLE_가 붙는다.
    		   .anyRequest().authenticated()//위 경우를 제외하고 나머지 모든 경우에 대해서 허용
    		   )//authorizeHttpRequests end 익명함수->람다식표현방식임.부트 3버전인 경우 시큐리티 버전이 6버전임 그럴때 이 공식 사용, 시큐리티 버전이 5버전인 경우 다른 방식 사용
       
               .formLogin(formlogin -> formlogin
            		   .defaultSuccessUrl("/all"))
               .logout(logout -> logout
            		   .logoutSuccessUrl("/all")
            		   .invalidateHttpSession(true));
                
               return http.build();
    }//filterChain end
    //메모리 방식 등록: 프로젝트를 일시적으로 사용 빌드업 패턴
    //초기값으로 어떤 값을 가진다.
    /*
    @Bean//메모리상 인증정보 등록 => 테스트 전용 방식
    InMemoryUserDetailsManager InMemoryUserDetailsService() {
    	UserDetails user = User.builder()
    			               .username("user1")
    			               .password(passwordEncoder().encode("1234"))
    			               .roles("USER") //ROLE_USER //한사람이 여러개의 권한을 가질 수 있음.
    			               //.authorities("ROLE_USER")
    			               .build();
    	
    	UserDetails admin =User.builder()
	                           .username("admin1")
	                           .password(passwordEncoder().encode("1234"))
	                           //.roles("ADMIN")
	                           .authorities("ROLE_USER","ROLE_ADMIN")
	                           .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    */
}//SpringSecurityConfig end
