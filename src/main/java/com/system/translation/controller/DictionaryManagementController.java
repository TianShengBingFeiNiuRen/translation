package com.system.translation.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.translation.service.DictionaryManagementService;
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
 * 词库管理
 */
@Slf4j
@RestController
public class DictionaryManagementController {

    @Resource
    private DictionaryManagementService dictionaryManagementService;

    /**
     * 新增词库内容
     */
    @PostMapping(value = "/dictionary/add")
    public StandardResponse add(String chinese, String english, HttpServletRequest httpServletRequest) {
        log.info("add!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return dictionaryManagementService.add(chinese, english);
    }

    /**
     * 删除词库内容
     */
    @PostMapping(value = "/dictionary/delete")
    public StandardResponse delete(String id, HttpServletRequest httpServletRequest) {
        log.info("delete!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return dictionaryManagementService.delete(id);
    }

    /**
     * 修改词库内容
     */
    @PostMapping(value = "/dictionary/modify")
    public StandardResponse modify(String id, String chinese, String english, HttpServletRequest httpServletRequest) {
        log.info("modify!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return dictionaryManagementService.modify(id, chinese, english);
    }

    /**
     * 查询所有词库内容
     */
    @GetMapping(value = "/dictionary/get-all")
    public StandardResponse getAll(HttpServletRequest httpServletRequest) {
        log.info("delete!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return dictionaryManagementService.getAll();
    }
}
