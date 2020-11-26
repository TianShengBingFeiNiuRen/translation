package com.system.translation.service;

import com.system.translation.dao.DatabaseRepository;
import com.system.translation.util.StandardResponse;
import com.system.translation.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Andon
 * 2020/11/26
 * <p>
 * 用户管理
 */
@Slf4j
@Transactional
@Service
public class UserManagementService {

    @Resource
    private DatabaseRepository databaseRepository;

    /**
     * 新增用户信息
     */
    public StandardResponse add(String username, String nickname, String password, String phone, String eMail, String qq, String weChat) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(username) && !ObjectUtils.isEmpty(password)) {
                int count = databaseRepository.getUserCountWhereUsername(username);
                if (count > 0) {
                    standardResponse.setMessage("新增的用户名已存在!!");
                } else {
                    String id = UUID.randomUUID().toString().replaceAll("-", "");
                    String updateTime = TimeUtil.FORMAT.get().format(System.currentTimeMillis());
                    int i = databaseRepository.addUser(id, username, nickname, password, phone, eMail, qq, weChat, updateTime);
                    standardResponse = StandardResponse.successStandardResponse();
                    standardResponse.setTotal(i);
                }
            }
        } catch (Exception e) {
            log.error("add failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }

    /**
     * 删除用户信息
     */
    public StandardResponse delete(String id) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(id)) {
                int i = databaseRepository.deleteUser(id);
                standardResponse = StandardResponse.successStandardResponse();
                standardResponse.setTotal(i);
            }
        } catch (Exception e) {
            log.error("delete failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }

    /**
     * 修改用户信息
     */
    public StandardResponse modify(String id, String username, String nickname, String password, String phone, String eMail, String qq, String weChat) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(id) && !ObjectUtils.isEmpty(username) && !ObjectUtils.isEmpty(password)) {
                int count = databaseRepository.getUserCountWhereIdAndUsername(id, username);
                if (count > 0) {
                    standardResponse.setMessage("要修改的用户名已存在!!");
                } else {
                    String updateTime = TimeUtil.FORMAT.get().format(System.currentTimeMillis());
                    int i = databaseRepository.modifyUser(id, username, nickname, password, phone, eMail, qq, weChat, updateTime);
                    standardResponse = StandardResponse.successStandardResponse();
                    standardResponse.setTotal(i);
                }
            }
        } catch (Exception e) {
            log.error("modify failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }

    /**
     * 查询所有用户信息
     */
    public StandardResponse getAll() {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        try {
            List<Map<String, String>> list = databaseRepository.getAllUser();
            int total = 0;
            if (!ObjectUtils.isEmpty(list)) {
                total = list.size();
            }
            standardResponse = StandardResponse.successStandardResponse();
            standardResponse.setData(list);
            standardResponse.setTotal(total);
        } catch (Exception e) {
            log.error("getAll failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }
}
