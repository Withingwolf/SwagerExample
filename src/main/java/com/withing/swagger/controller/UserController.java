package com.withing.swagger.controller;

import com.withing.swagger.domain.*;
import io.swagger.annotations.*;
import org.apache.commons.lang.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangweixin1@jd.com
 * create 2018/12/6 13:55
 */
@Api(value = "/api", description = "swagger示例接口", tags = "example")
@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
public class UserController {

    @ApiOperation("通过userId搜索User")
    @GetMapping("/query/{userId}")
    public User query(@PathVariable Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setName(RandomStringUtils.random(5, true, false));
        return user;
    }

}
