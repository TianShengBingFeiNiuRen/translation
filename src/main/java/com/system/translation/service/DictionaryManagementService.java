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
 * 词库管理
 */
@Slf4j
@Transactional
@Service
public class DictionaryManagementService {

    @Resource
    private DatabaseRepository databaseRepository;

    /**
     * 新增词库内容
     */
    public StandardResponse add(String chinese, String english) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(chinese) && !ObjectUtils.isEmpty(english)) {
                int count = databaseRepository.getDictionaryCount(chinese, english);
                if (count > 0) {
                    standardResponse.setMessage("词库已存在该词句内容!!");
                } else {
                    String id = UUID.randomUUID().toString().replaceAll("-", "");
                    String updateTime = TimeUtil.FORMAT.get().format(System.currentTimeMillis());
                    int i = databaseRepository.addDictionary(id, chinese, english, updateTime);
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
     * 删除词库内容
     */
    public StandardResponse delete(String id) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(id)) {
                int i = databaseRepository.deleteDictionary(id);
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
     * 修改词库内容
     */
    public StandardResponse modify(String id, String chinese, String english) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(id)) {
                String updateTime = TimeUtil.FORMAT.get().format(System.currentTimeMillis());
                int i = databaseRepository.modifyDictionary(id, chinese, english, updateTime);
                standardResponse = StandardResponse.successStandardResponse();
                standardResponse.setTotal(i);
            }
        } catch (Exception e) {
            log.error("modify failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }

    /**
     * 修改词库内容
     */
    public StandardResponse getAll() {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        try {
            List<Map<String, String>> list = databaseRepository.getAllDictionary();
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
