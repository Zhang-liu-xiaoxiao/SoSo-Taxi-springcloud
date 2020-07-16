package com.apicaller.sosotaxi.entity.dispatch.dto;

import lombok.Data;

/**
 * @author 张流潇潇
 * @createTime 2020/7/16
 * @updateTime
 * 登陆了的司机，储存坐标
 */
@Data
public class LoginDriver {


    /** 纬度 */
    private double lat;

    /** 经度 */
    private double lng;

    /** 用户名 */
    private String userName;

    /** 用户token */
    private String token;

    /** 司机是否已经接单了 yes or no */
    private String isDispatched;

}