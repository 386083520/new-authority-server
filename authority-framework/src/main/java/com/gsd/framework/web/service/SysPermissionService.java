package com.gsd.framework.web.service;

import com.gsd.common.core.domain.entity.SysUser;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SysPermissionService {
    public Set<String> getMenuPermission(SysUser user) {
        Set<String> perms = new HashSet<String>();
        if(user.isAdmin()) {
            perms.add("*:*:*");
        }else {

        }
        return perms;
    }
}
