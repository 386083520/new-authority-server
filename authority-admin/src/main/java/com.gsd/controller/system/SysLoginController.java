package com.gsd.controller.system;

import com.gsd.common.constant.Constants;
import com.gsd.common.core.domain.AjaxResult;
import com.gsd.common.core.domain.model.LoginBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLoginController {
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put(Constants.TOKEN, "123");
        return ajaxResult;
    }
}
