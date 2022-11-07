package com.gsd.controller.system;

import com.gsd.common.constant.Constants;
import com.gsd.common.core.domain.AjaxResult;
import com.gsd.common.core.domain.entity.SysUser;
import com.gsd.common.core.domain.model.LoginBody;
import com.gsd.common.core.domain.model.LoginUser;
import com.gsd.common.utils.SecurityUtils;
import com.gsd.framework.web.service.SysLoginService;
import com.gsd.framework.web.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private SecurityUtils securityUtils;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajaxResult = AjaxResult.success();
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        ajaxResult.put(Constants.TOKEN, token);
        return ajaxResult;
    }

    @GetMapping("/getInfo")
    public AjaxResult getInfo(HttpServletRequest request) {
        SysUser user = securityUtils.getLoginUser().getUser();
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", null);
        ajax.put("permissions", permissions);
        return ajax;
    }
}
