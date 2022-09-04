package com.gsd.controller.common;

import com.google.code.kaptcha.Producer;
import com.gsd.common.core.domain.AjaxResult;
import com.gsd.common.utils.uuid.IdUtils;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        BufferedImage image = null;
        if("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            System.out.println(capText);
            image = captchaProducerMath.createImage(capText);
        }
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }
}
