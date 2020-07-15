package com.apicaller.sosotaxi.controller;

import com.apicaller.sosotaxi.entity.Order;
import com.apicaller.sosotaxi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author 骆荟州
 * @createTime   2020-07-14 23:18:55
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param orderId 主键
     * @return 单条数据
     */
    @GetMapping("/getById")
    public Order getById(Long orderId) {
        return orderService.queryById(orderId);
    }

    @GetMapping("/getByPassengerId")
    public List<Order> getByPassengerId(long passengerId) {
        return orderService.queryByPassengerId(passengerId);
    }

    @GetMapping("/getByDriverId")
    public List<Order> getByDriverId(long driverId) {
        return orderService.queryByDriverId(driverId);
    }

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        return orderService.insert(order);
    }

    @PutMapping("/updateOrder")
    public int updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("deleteOrder")
    public boolean deleteOrder(long orderId) {
        return orderService.deleteById(orderId);
    }
}