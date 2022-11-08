package com.gsd.common.utils;

import com.gsd.common.constant.Constants;
import com.gsd.common.constant.HttpStatus;
import com.gsd.common.core.domain.model.LoginUser;
import com.gsd.common.core.redis.RedisCache;
import com.gsd.common.exception.ServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SecurityUtils {


    public static LoginUser getLoginUser() {
       try {
           return (LoginUser) getAuthentication().getPrincipal();
       } catch (Exception e) {
           throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
       }
    }

    public static Long getUserId() {
        return getLoginUser().getUserId();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }
}
