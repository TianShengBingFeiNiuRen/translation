package com.system.translation.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.translation.service.LoginService;
import com.system.translation.util.StandardResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Andon
 * 2020/11/26
 * <p>
 * 登录
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public StandardResponse login(String username, String password, HttpServletRequest httpServletRequest) {
        log.info("login!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return loginService.login(username, password);
    }
}
