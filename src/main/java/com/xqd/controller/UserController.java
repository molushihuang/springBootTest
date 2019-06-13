package com.xqd.controller;

import com.xqd.entity.MyJson;
import com.xqd.entity.userBean;
import com.xqd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 帐号登录Controller
 *
 * @author ljj
 * @version 2018-06-26
 */
@Api(tags = {"用户模块"})
@RestController
@RequestMapping("/account")
public class UserController {

    @Autowired
    private UserService mUserService;

    @ApiOperation(value = "获取用户列表", notes = "", response = userBean.class)
    @PostMapping("/getUserList")
    public MyJson getUserList(HttpServletRequest request) {
        MyJson json = new MyJson();
        json.setCode("200");
        json.setMessage("获取成功");
        json.setSuccess(true);
        json.setData(mUserService.getUserList());
        return json;
    }


    @ApiOperation(value = "插入一个用户", notes = "", response = MyJson.class)
    @PostMapping("/addUser")
    public MyJson addUser(@ApiParam(value = "名字", required = true) @RequestParam(value = "name") String name,
                          @ApiParam(value = "幸运数字", required = true) @RequestParam(value = "luckyNumber") int luckyNumber,
                          HttpServletRequest request) {
        MyJson json = new MyJson();
        boolean has = false;

        try {

            for (userBean userBean : mUserService.getUserList()) {
                if (name.equals(userBean.getName())) {
                    has = true;
                    break;
                }
            }

            if (has) {
                json.setCode("500");
                json.setMessage("添加失败.有同名用户");
                json.setSuccess(false);
            } else {
                userBean userBean = new userBean();
                userBean.setName(name);
                userBean.setLuckyNumber(luckyNumber);
                mUserService.addUser(userBean);
                json.setCode("200");
                json.setMessage("添加成功");
                json.setSuccess(true);
            }

        } catch (Exception e) {
            json.setCode("500");
            json.setMessage("添加失败");
            json.setSuccess(false);
        }

        return json;
    }

    @ApiOperation(value = "更新用户信息", notes = "", response = MyJson.class)
    @PostMapping("/updateUser")
    public MyJson updateUser(@ApiParam(value = "id", required = true) @RequestParam(value = "id") int id,
                             @ApiParam(value = "名字", required = true) @RequestParam(value = "name") String name,
                             @ApiParam(value = "幸运数字", required = true) @RequestParam(value = "luckyNumber") int luckyNumber,
                             HttpServletRequest request) {
        MyJson json = new MyJson();

        try {
            mUserService.updateUser(id, name, luckyNumber);
            json.setCode("200");
            json.setMessage("更新成功");
            json.setSuccess(true);
        } catch (Exception e) {
            json.setCode("500");
            json.setMessage("更新失败");
            json.setSuccess(false);
        }

        return json;
    }

    @ApiOperation(value = "删除一个用户", notes = "", response = MyJson.class)
    @PostMapping("/delUser")
    public MyJson delUser(@ApiParam(value = "id", required = true) @RequestParam(value = "id") int id, HttpServletRequest request) {
        MyJson json = new MyJson();

        try {

            mUserService.delUser(id);
            json.setCode("200");
            json.setMessage("删除成功");
            json.setSuccess(true);
        } catch (Exception e) {
            json.setCode("500");
            json.setMessage("删除失败");
            json.setSuccess(false);
        }

        return json;
    }
}
