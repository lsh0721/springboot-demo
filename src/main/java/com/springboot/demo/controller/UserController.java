/*
 * Author:   lishihui
 * FileName: UserController
 * Date:     2019/12/20 14:23
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.dmo.User;
import com.springboot.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 14:23
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户服务接口")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 保存用户
     *
     * @param userName
     * @param address
     * @return
     */
    @RequestMapping(value = "/save.do", method = RequestMethod.GET)
    @ApiOperation("保存用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "姓名", defaultValue = "孙悟空", required = true),
            @ApiImplicitParam(name = "address", value = "地址", defaultValue = "花果山", required = true)})
    public String save(String userName, String address) {
        String result = "success";
        log.info("保存用户信息userName:{},address:{}", userName, address);
        User user = new User();
        user.setUserName(userName);
        user.setAddress(address);
        try {
            userInfoService.save(user);
        } catch (DuplicateKeyException dup) {
            log.info("保存用户信息userName:{},address:{},DuplicateKeyException:{}", new Object[]{userName, address, dup});
            result = "user duplicate error";
        } catch (Exception e) {
            log.info("保存用户信息userName:{},address:{},exception:{}", new Object[]{userName, address, e});
            result = "error";
        }
        return result;
    }

    /**
     * 传用户列表
     *
     * @return
     */
    @RequestMapping(value = "/list.do")
    @ApiOperation("查询用户列表")
    public List<User> listForAllUser() {
        return userInfoService.list();
    }

    /**
     * 更新用户
     *
     * @param userName
     * @param address
     * @return
     */
    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    @ApiOperation("更新用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "姓名", defaultValue = "孙悟空", required = true),
            @ApiImplicitParam(name = "address", value = "地址", defaultValue = "花果山", required = true)})
    public String update(String userName, String address) {
        String result = "success";
        log.info("更新用户信息userName:{},address:{}", userName, address);
        User user = new User();
        user.setUserName(userName);
        user.setAddress(address);
        try {
            userInfoService.update(user);
        } catch (Exception e) {
            log.info("更新用户信息userName:{},address:{},exception:{}", new Object[]{userName, address, e});
            result = "error";
        }
        return result;
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    @ApiOperation("查询用户")
    @ApiImplicitParam(name = "userName", value = "姓名", defaultValue = "孙悟空", required = true)
    public User getUserByName(String userName) {
        log.info("根据用户名查询用户，userName:{}", userName);
        return userInfoService.getUserByName(userName);
    }


    /**
     * 根据用户名删除用户
     *
     * @param userName
     * @return success:删除成功 否则删除失败
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "userName", value = "姓名", defaultValue = "孙悟空", required = true)
    public String deleteUserByName(String userName) {
        String result = "success";
        log.info("根据用户名删除用户，userName:{}", userName);
        try {
            userInfoService.deleteUserByName(userName);
        } catch (Exception e) {
            log.info("根据用户名删除用户，userName:{},Exception", userName);
            result = "error";
        }
        return result;
    }
}
