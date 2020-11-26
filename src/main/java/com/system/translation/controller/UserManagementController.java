package com.system.translation.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.translation.service.UserManagementService;
import com.system.translation.util.StandardResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Andon
 * 2020/11/26
 * <p>
 * 用户管理
 */
@Slf4j
@RestController
public class UserManagementController {

    @Resource
    private UserManagementService userManagementService;

    /**
     * 新增用户信息
     */
    @PostMapping(value = "/user/add")
    public StandardResponse add(String username, String nickname, String password, String phone, String eMail, String qq, String weChat, HttpServletRequest httpServletRequest) {
        log.info("add!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return userManagementService.add(username, nickname, password, phone, eMail, qq, weChat);
    }

    /**
     * 删除用户信息
     */
    @PostMapping(value = "/user/delete")
    public StandardResponse delete(String id, HttpServletRequest httpServletRequest) {
        log.info("delete!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return userManagementService.delete(id);
    }

    /**
     * 修改用户信息
     */
    @PostMapping(value = "/user/modify")
    public StandardResponse modify(String id, String username, String nickname, String password, String phone, String eMail, String qq, String weChat, HttpServletRequest httpServletRequest) {
        log.info("modify!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return userManagementService.modify(id, username, nickname, password, phone, eMail, qq, weChat);
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping(value = "/user/get-all")
    public StandardResponse getAll(HttpServletRequest httpServletRequest) {
        log.info("delete!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return userManagementService.getAll();
    }
}
