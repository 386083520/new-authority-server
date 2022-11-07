package com.gsd.system.mapper;

import java.util.List;

public interface SysRoleMapper {
    public List<String> selectRolePermissionByUserId(Long userId);
}
