package com.example.data.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.data.entity.User;
import com.example.data.service.UserService;
import com.example.data.utils.RedisClient;
import com.example.data.utils.Result;
import com.example.data.utils.ResultCode;
import com.example.data.utils.ResultMsg;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class CaptchaCotroller {
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private UserService userService;
    @RequestMapping("/captcha")
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为30分钟
        redisClient.set(key, verCode, 100);
        // 将key和base64返回给前端
        Map<String,String> map=new HashMap<>();
        map.put("key",key);
        map.put("image",specCaptcha.toBase64());
        Result result=new Result();
        return result.success(map);
    }

    @PostMapping("/login")
    public Result login(String username,String password,String verCode,String verKey){
        // 获取redis中的验证码
        String redisCode = redisClient.get(verKey);
        System.out.println(redisCode);
        Result result=new Result();
        // 判断验证码
        if (verCode==null || !redisCode.equals(verCode.trim().toLowerCase())) {
            return result.error(ResultCode.CAPTCHA_ERROR, ResultMsg.CAPTCHA_ERROR);
        }

        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List list = userService.list(queryWrapper);
        User user= (User) list.get(0);
        if(user==null){
            return result.error(ResultCode.LOGIN_USER_ERROR,ResultMsg.LOGIN_USER_ERROR);
        }
        return result.success();
    }


}
