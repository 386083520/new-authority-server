package com.gsd.framework.web.service;

import com.gsd.common.core.domain.entity.SysUser;
import com.gsd.common.core.domain.model.LoginUser;
import com.gsd.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ISysUserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUserName(username);
        return creatLoginUser(user);
    }

    public UserDetails creatLoginUser(SysUser user) {
        return new LoginUser(user);
    }
}
