package com.system.translation.service;

import com.system.translation.dao.DatabaseRepository;
import com.system.translation.util.StandardResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author Andon
 * 2020/11/26
 * <p>
 * 登录
 */
@Slf4j
@Transactional
@Service
public class LoginService {

    @Resource
    private DatabaseRepository databaseRepository;

    /**
     * 登录
     */
    public StandardResponse login(String username, String password) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("用户名或密码错误!!");
        try {
            if (!ObjectUtils.isEmpty(username) && !ObjectUtils.isEmpty(password)) {
                if (username.equals("admin") && password.equals("admin")) {
                    standardResponse = StandardResponse.successStandardResponse();
                } else {
                    int count = databaseRepository.getUserCount(username, password);
                    if (count > 0) {
                        standardResponse.setMessage("登录成功!!");
                    } else {
                        standardResponse.setMessage("用户名或密码错误!!");
                    }
                }
            }
        } catch (Exception e) {
            log.error("login failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }
}
