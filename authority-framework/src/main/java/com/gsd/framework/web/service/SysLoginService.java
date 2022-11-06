package com.gsd.framework.web.service;

import com.gsd.common.exception.ServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    public String login(String username, String password, String code, String uuid) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e) {
            if(e instanceof BadCredentialsException) {
                throw new ServiceException(e.getMessage());
            }else {
                throw new ServiceException(e.getMessage());
            }
        }
        return "123";
    }
}
