package com.gsd.system.mapper;


import com.gsd.system.domain.SysUser;

import java.util.List;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-03
 */
public interface SysUserMapper 
{

    /**
     * 查询用户信息列表
     * 
     * @param sysUser 用户信息
     * @return 用户信息集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);
}
