package com.gsd.system.service;

import com.gsd.common.core.domain.entity.SysMenu;

import java.util.List;
import java.util.Set;

public interface ISysMenuService {
    public Set<String> selectMenuPermsByUserId(Long userId);

    public List<SysMenu> selectMenuTreeByUserId(Long userId);
}
