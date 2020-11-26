package com.system.translation.dao;

import com.system.translation.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Andon
 * 2020/11/26
 */
@Repository
public interface DatabaseRepository extends JpaRepository<Dictionary, String> {

    @Query(nativeQuery = true, value = "SELECT COUNT(`id`) FROM `user` WHERE `username`=?1 AND `password`=?2")
    int getUserCount(String username, String password);

    @Query(nativeQuery = true, value = "SELECT `english` FROM `dictionary` WHERE `chinese`=?1")
    String getDictionaryWhereChinese(String chinese);

    @Query(nativeQuery = true, value = "SELECT `chinese` FROM `dictionary` WHERE `english`=?1")
    String getDictionaryWhereEnglish(String english);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO `dictionary` (`id`,`chinese`,`english`,`update_time`) VALUES (?1,?2,?3,?4)")
    int addDictionary(String id, String chinese, String english, String updateTime);

    @Query(nativeQuery = true, value = "SELECT COUNT(`id`) FROM `dictionary` WHERE `chinese`=?1 OR `english`=?2")
    int getDictionaryCount(String chinese, String english);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM `dictionary` WHERE `id`=?1")
    int deleteDictionary(String id);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE `dictionary` SET `chinese`=?2,`english`=?3,`update_time`=?4 WHERE `id`=?1")
    int modifyDictionary(String id, String chinese, String english, String updateTime);

    @Query(nativeQuery = true, value = "SELECT `id`,`chinese`,`english`,`update_time` AS `updateTime` FROM `dictionary` ORDER BY `update_time`")
    List<Map<String, String>> getAllDictionary();

    @Query(nativeQuery = true, value = "SELECT COUNT(`id`) FROM `user` WHERE `username`=?1")
    int getUserCountWhereUsername(String username);

    @Query(nativeQuery = true, value = "SELECT COUNT(`id`) FROM `user` WHERE `id`!=?1 AND `username`=?2")
    int getUserCountWhereIdAndUsername(String id, String username);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO `user` (`id`,`username`,`nickname`,`password`,`phone`,`e_mail`,`qq`,`we_chat`,`update_time`) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)")
    int addUser(String id, String username, String nickname, String password, String phone, String eMail, String qq, String weChat, String updateTime);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM `user` WHERE `id`=?1")
    int deleteUser(String id);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE `user` SET `username`=?2,`nickname`=?3,`password`=?4,`phone`=?5,`e_mail`=?6,`qq`=?7,`we_chat`=?8,`update_time`=?9 WHERE `id`=?1")
    int modifyUser(String id, String username, String nickname, String password, String phone, String eMail, String qq, String weChat, String updateTime);

    @Query(nativeQuery = true, value = "SELECT `id`,`username`,`nickname`,`password`,`phone`,`e_mail` AS `eMail`,`qq`,`we_chat` AS `weChat`,`update_time` AS `updateTime` FROM `user` ORDER BY `update_time`")
    List<Map<String, String>> getAllUser();
}
