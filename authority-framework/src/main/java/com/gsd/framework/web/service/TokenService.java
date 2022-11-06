package com.gsd.framework.web.service;

import com.gsd.common.constant.Constants;
import com.gsd.common.core.domain.model.LoginUser;
import com.gsd.common.core.redis.RedisCache;
import com.gsd.common.utils.uuid.IdUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class TokenService {
    private String secret = "gdsafdasgdsfdasgfhgdsgf";
    private int expireTime = 30;

    @Autowired
    private RedisCache redisCache;

    public String createToken(LoginUser loginUser) {
        String token = IdUtils.fastUUID();
        loginUser.setToken(token);
        refreshToken(loginUser);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    private void refreshToken(LoginUser loginUser) {
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    private String getTokenKey(String uuid) {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }
}