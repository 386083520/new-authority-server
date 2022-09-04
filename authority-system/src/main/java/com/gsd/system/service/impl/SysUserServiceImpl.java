package com.gsd.system.service.impl;


import com.gsd.system.domain.SysUser;
import com.gsd.system.mapper.SysUserMapper;
import com.gsd.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-03
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户信息列表
     * 
     * @param sysUser 用户信息
     * @return 用户信息
     */
    public List<SysUser> selectSysUserList(SysUser sysUser)
    {
        return sysUserMapper.selectSysUserList(sysUser);
    }
}
