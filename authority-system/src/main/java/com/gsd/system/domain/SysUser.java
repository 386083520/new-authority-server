package com.gsd.system.domain;

/**
 * 用户信息对象 sys_user
 * 
 * @author ruoyi
 * @date 2022-09-03
 */
public class SysUser
{
    private static final long serialVersionUID = 1L;



    private String userName;




    public String getUserName() 
    {
        return userName;
    }


    @Override
    public String toString() {
        return getUserName();
    }
}
