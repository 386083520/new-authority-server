package com.gsd.system.service.impl;

import com.gsd.common.core.domain.entity.SysMenu;
import com.gsd.common.utils.SecurityUtils;
import com.gsd.common.utils.StringUtils;
import com.gsd.system.mapper.SysMenuMapper;
import com.gsd.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return getChildPerms(menus, 0);
    }

    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId) {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for(Iterator<SysMenu> iterator = list.iterator();iterator.hasNext();) {
            SysMenu t = iterator.next();
            if(t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    private void recursionFn(List<SysMenu> list, SysMenu t) {
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for(SysMenu tChild: childList) {
            if(hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    private boolean hasChild(List<SysMenu> list, SysMenu t) {
        return getChildList(list, t).size() > 0;
    }

    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t) {
        List<SysMenu> tList = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext()) {
            SysMenu n = (SysMenu)it.next();
            if(n.getParentId() == t.getMenuId()) {
                tList.add(n);
            }
        }
        return tList;
    }
}
