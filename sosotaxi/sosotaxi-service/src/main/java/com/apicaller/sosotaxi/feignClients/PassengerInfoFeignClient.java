package com.apicaller.sosotaxi.feignClients;

import com.apicaller.sosotaxi.entity.Passenger;
import com.apicaller.sosotaxi.entity.PassengerVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: 骆荟州
 * @createTime: 2020/7/14 3:24 下午
 * @updateTime:
 */

@FeignClient(name = "user-service")
@Service
public interface PassengerInfoFeignClient {

    /**
     * 根据用户id获取乘客信息
     * @param userId
     * @return Passenger
     */
    @RequestMapping(method = RequestMethod.GET,value = "/passenger/getById")
    Passenger getPassengerById(@RequestParam("userId") long userId);

    /**
     * 根据用户名获取乘客信息
     * @param username
     * @return Passenger
     */
    @RequestMapping(method = RequestMethod.GET,value = "/passenger/getByName")
    Passenger getPassengerByName(@RequestParam("username") String username);

    /**
     * 新增乘客信息
     * @param passenger
     * @return 影响的行数
     */
    @RequestMapping(method = RequestMethod.POST,value = "/passenger/addPassenger")
    int addPassenger(@RequestBody PassengerVo passenger);

    /**
     * 修改乘客信息
     * @param passenger
     * @return 影响的行数
     */
    @RequestMapping(method = RequestMethod.PUT,value = "/passenger/updatePassenger")
    int updatePassenger(@RequestBody PassengerVo passenger);
}
