package com.example.data.utils;

import lombok.Data;

@Data
public class ResultCode {
    public static final int SUCCESS=200;
    public static final int FAIL=400;
    public static final int CAPTCHA_ERROR=401;
    public static final int LOGIN_USER_ERROR=402;
    public static final int ERROR=500;
}
