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
 * 双向翻译
 */
@Slf4j
@Transactional
@Service
public class TwoWayTranslationService {

    @Resource
    private DatabaseRepository databaseRepository;

    /**
     * 双向翻译
     */
    public StandardResponse translation(String chinese, String english) {
        StandardResponse standardResponse = StandardResponse.failureStandardResponse();
        standardResponse.setMessage("参数缺失!!");
        try {
            if (!ObjectUtils.isEmpty(chinese) || !ObjectUtils.isEmpty(english)) {
                String result = null;
                if (!ObjectUtils.isEmpty(chinese)) {
                    result = databaseRepository.getDictionaryWhereChinese(chinese);
                } else if (!ObjectUtils.isEmpty(english)) {
                    result = databaseRepository.getDictionaryWhereEnglish(english);
                }
                standardResponse = StandardResponse.successStandardResponse();
                if (!ObjectUtils.isEmpty(result)) {
                    standardResponse.setData(result);
                } else {
                    standardResponse.setMessage("查询词句不在词库中,请联系管理员添加该词句内容!!");
                    standardResponse.setData("查询词句不在词库中,请联系管理员添加该词句内容!!");
                }
            }
        } catch (Exception e) {
            log.error("translation failure!! error={}", e.getMessage());
            e.printStackTrace();
        }
        return standardResponse;
    }
}
