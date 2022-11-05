package com.gsd.framework.web.service;

import com.gsd.common.core.domain.model.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return creatLoginUser();
    }

    public UserDetails creatLoginUser() {
        return new LoginUser();
    }
}
