package com.gsd.system.service.impl;

import com.gsd.common.core.domain.entity.SysMenu;
import com.gsd.common.utils.SecurityUtils;
import com.gsd.common.utils.StringUtils;
import com.gsd.system.mapper.SysMenuMapper;
import com.gsd.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysMenuServiceImpl implements ISysMenuService{
    @Autowired
    private SysMenuMapper menuMapper;

    public Set<String> selectMenuPermsByUserId(Long userId) {
        List<String> perms = menuMapper.selectMenuPermsByUserId(userId);
        Set<String> permsSet = new HashSet<String>();
        for (String perm: perms) {
            if(StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    public List<SysMenu> selectMenuTreeByUserId(Long userId) {
        List<SysMenu> menus = null;
        if(SecurityUtils.isAdmin(userId)) {
            menus = menuMapper.selectMenuTreeAll();
        }
        return menus;
    }
}
