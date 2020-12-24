package io.gy.plat.controller;


import io.gy.plat.entity.ResultEntity;
import io.gy.plat.util.ResultUtil;
import io.gy.plat.util.ValidateCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author lbavsc
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    /**
     * 获得验证码并发送
     *
     * @param request  request
     * @param response response
     */
    @GetMapping("/getCaptchaImg")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 设置发送到客户端的响应的内容类型
            response.setContentType("image/png");
            // 没有缓存
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            validateCode.getRandomCodeImage(request, response, ValidateCodeUtil.IMG);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得验证码并发送
     *
     * @param request  request
     * @param response response
     */
    @GetMapping("/getCaptchaImgBase64")
    public ResultEntity getCaptchaImgBase64(HttpServletRequest request, HttpServletResponse response) {
        try {
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            String result = validateCode.getRandomCodeImage(request, response, ValidateCodeUtil.BASE64);
            return ResultUtil.success(result);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("1001", "系统发生错误,请联系管理员");
        }
    }

    /**
     * 验证码校验
     *
     * @param code    接收到的验证码
     * @param session session
     * @return ResultEntity
     */
    @GetMapping("/checkCaptcha")
    public ResultEntity getCheckCaptcha(@RequestParam(value = "code") String code, HttpSession session) {

        try {

            String sessionCode;
            sessionCode = String.valueOf(session.getAttribute(ValidateCodeUtil.SESSION_KEY)).toLowerCase();
            System.out.println("session里的验证码：" + sessionCode);
            String receivedCode = code.toLowerCase();
            System.out.println("用户的验证码：" + receivedCode);
            //验证码验证后进行失效处理
            session.removeAttribute(ValidateCodeUtil.SESSION_KEY);

            if (!"".equals(sessionCode) && !"".equals(receivedCode) && sessionCode.equals(receivedCode)) {
                return ResultUtil.success(UUID.randomUUID());
            } else {
                return ResultUtil.error("1002", "验证码错误");
            }
        } catch (Exception e) {

            return ResultUtil.error("1001", "系统发生错误,请联系管理员");
        }
    }

    @GetMapping("/a")
    public ResultEntity a() {

        try {
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error("1001", "系统发生错误,请联系管理员");
        }
    }
}
