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
    private String header = "Authorization";

    private String secret = "gdsafdasgdsfdasgfhgdsgf";

    @Autowired
    private RedisCache redisCache;

    public LoginUser getLoginUser() {
        /*String token = getToken(request);
        if(StringUtils.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            String uuid = (String)claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            LoginUser user = redisCache.getCacheObject(userKey);
            return user;
        }
        return null;*/
       try {
           return (LoginUser) getAuthentication().getPrincipal();
       } catch (Exception e) {
           throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
       }
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(this.header);
        if(StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private String getTokenKey(String uuid) {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }
}
