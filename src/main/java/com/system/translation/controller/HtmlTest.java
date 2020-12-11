package com.system.translation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Andon
 * 2020/12/11
 */
@Slf4j
@Controller
public class HtmlTest {

    @GetMapping(value = "/index")
    public String index(){
        log.info("index!!");
        return "index";
    }
}
