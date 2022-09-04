package com.gsd.controller.common;

import com.gsd.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaptchaController {
    @GetMapping("/captchaImage")
    public AjaxResult getCode() {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = false;
        if(!captchaOnOff) {
            return  ajax;
        }
        return ajax;
    }
}
