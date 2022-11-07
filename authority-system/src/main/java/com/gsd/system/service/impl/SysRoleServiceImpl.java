package com.gsd.system.service.impl;

import com.gsd.common.utils.StringUtils;
import com.gsd.system.mapper.SysRoleMapper;
import com.gsd.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl implements ISysRoleService{
    @Autowired
    private SysRoleMapper roleMapper;

    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<String> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<String>();
        for (String perm: perms) {
            if(StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
