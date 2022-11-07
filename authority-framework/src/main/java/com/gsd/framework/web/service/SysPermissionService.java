package com.gsd.framework.web.service;

import com.gsd.common.core.domain.entity.SysUser;
import com.gsd.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SysPermissionService {
    @Autowired
    private ISysMenuService menuService;

    public Set<String> getMenuPermission(SysUser user) {
        Set<String> perms = new HashSet<String>();
        if(user.isAdmin()) {
            perms.add("*:*:*");
        }else {
            perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
        }
        return perms;
    }
}
