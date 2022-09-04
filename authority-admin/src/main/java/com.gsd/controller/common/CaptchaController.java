package com.gsd.controller.common;

import com.gsd.common.core.domain.AjaxResult;
import com.gsd.common.utils.uuid.IdUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaptchaController {
    @GetMapping("/captchaImage")
    public AjaxResult getCode() {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = true;
        if(!captchaOnOff) {
            return ajax;
        }
        String uuid = IdUtils.simpleUUID();
        ajax.put("uuid", uuid);
        ajax.put("img", "abc");
        return ajax;
    }
}
