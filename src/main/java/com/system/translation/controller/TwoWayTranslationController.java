package com.system.translation.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.translation.service.TwoWayTranslationService;
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
 * 双向翻译
 */
@Slf4j
@RestController
public class TwoWayTranslationController {

    @Resource
    private TwoWayTranslationService twoWayTranslationService;

    /**
     * 双向翻译
     */
    @PostMapping(value = "/two-way-translation/translation")
    public StandardResponse translation(String chinese, String english, HttpServletRequest httpServletRequest) {
        log.info("translation!! httpServletRequest.getParameterMap():{}", JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        return twoWayTranslationService.translation(chinese, english);
    }
}
