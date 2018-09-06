package com.wsmhz.api.gateway.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


/**
 * create by tangbj on 2018/8/19
 */
@Component
@Slf4j
public class CommonUserDetailsService implements UserDetailsService,SocialUserDetailsService {

    //    @Autowired
//    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder; //可经过配置自定义的密码加密

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("表单登陆用户名:" + username);
        return buildUser(username);
    }


    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("social登录用户名:" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        String password = passwordEncoder.encode("123456");
        return new SocialUser(userId,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }
}
