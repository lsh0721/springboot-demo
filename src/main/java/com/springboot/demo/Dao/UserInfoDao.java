/*
 * Author:   lishihui
 * FileName: UserInfoDao
 * Date:     2019/12/20 14:37
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.Dao;

import com.springboot.demo.dmo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 14:37
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface UserInfoDao {

    /**
     * 保存用户
     *
     * @param userInfo
     */
    void save(User userInfo);

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<User> list();

    /**
     * 更新用户
     *
     * @param user
     */
    void update(User user);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User getUserByName(String userName);

    /**
     * 根据用户名删除用户
     *
     * @param userName
     */
    void deleteUserByName(String userName);

}
