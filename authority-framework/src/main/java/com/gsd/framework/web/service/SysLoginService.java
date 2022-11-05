package com.gsd.framework.web.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    public String login(String username, String password, String code, String uuid) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return "123";
    }
}
