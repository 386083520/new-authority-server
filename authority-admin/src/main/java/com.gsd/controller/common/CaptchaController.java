package com.gsd.controller.common;

import com.google.code.kaptcha.Producer;
import com.gsd.common.core.domain.AjaxResult;
import com.gsd.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CaptchaController {
    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;


    @GetMapping("/captchaImage")
    public AjaxResult getCode() {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = true;
        if(!captchaOnOff) {
            return ajax;
        }
        String uuid = IdUtils.simpleUUID();
        String captchaType = "math";
        if("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            System.out.println(capText);
        }
        ajax.put("uuid", uuid);
        ajax.put("img", "abc");
        return ajax;
    }
}
