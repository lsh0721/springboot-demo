/*
 * Author:   lishihui
 * FileName: UserInfoServiceImpl
 * Date:     2019/12/20 14:49
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.service.impl;

import com.springboot.demo.Dao.UserInfoDao;
import com.springboot.demo.dmo.User;
import com.springboot.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 14:49
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public void save(User userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    public List<User> list() {
        return userInfoDao.list();
    }

    @Override
    public void update(User user) {
        userInfoDao.update(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userInfoDao.getUserByName(userName);
    }

    @Override
    public void deleteUserByName(String userName) {
        userInfoDao.deleteUserByName(userName);
    }
}
