/*
 * Author:   lishihui
 * FileName: UserInfoDaoImpl
 * Date:     2019/12/20 14:39
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.Dao.impl;

import com.springboot.demo.Dao.UserInfoDao;
import com.springboot.demo.dmo.User;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 14:39
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Component
@Slf4j
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void save(User userInfo) {
        sqlSessionTemplate.insert("saveUser", userInfo);
    }

    @Override
    public List<User> list() {
        return sqlSessionTemplate.selectList("getAllUserForList");
    }

    @Override
    public void update(User user) {
        sqlSessionTemplate.update("updateUserInfo", user);
    }

    @Override
    public User getUserByName(String userName) {
        return sqlSessionTemplate.selectOne("getUserByName", userName);
    }

    @Override
    public void deleteUserByName(String userName) {
        sqlSessionTemplate.delete("deleteUserByName", userName);
    }
}
