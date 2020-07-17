package com.apicaller.sosotaxi.service;

import com.apicaller.sosotaxi.entity.MinimizedDriver;
import com.apicaller.sosotaxi.entity.UnsettledOrder;
import com.apicaller.sosotaxi.entity.GeoPoint;

import java.util.List;
import java.util.Set;

public interface InfoCacheService {

    /**
     * 获取司机的有效信息
     * @param driverId
     * @return
     */
    MinimizedDriver getDriver(String driverId);

    /**
     * 获取在线司机名单
     * @return
     */
    Set<String> getAllDrivers();

    /**
     * 通过详细信息更新司机hash
     * @param city
     * @param type
     * @param driverId
     * @param point
     * @return
     * @throws Exception
     */
    Boolean updateDriverField(String city, int type, String driverId, GeoPoint point) throws Exception;

    /**
     * 更新司机hash
     * @param driver
     * @param point
     * @return
     * @throws Exception
     */
    Boolean updateDriverField(MinimizedDriver driver, GeoPoint point) throws Exception;

    /**
     * 获取司机位置
     * @param driverId
     * @return
     */
    GeoPoint getDriverPosition(String driverId);

    /**
     * 通过司机id删除hash中的field
     * @param driverId
     * @return
     * @throws Exception
     */
    void deleteDriverField(String driverId) throws Exception;

    /**
     * 通过司机id更新司机位置
     * @param driverId
     * @param point
     * @throws Exception
     */
    void updatePoint(String driverId, GeoPoint point) throws Exception;

    /**
     * 更新未分配订单hash
     * @param orderId
     * @param uOrder
     */
    void updateUOrderField(String orderId, UnsettledOrder uOrder);

    /**
     * 获取未分配订单
     * @param orderId
     * @return
     */
    UnsettledOrder getUOrder(String orderId);

    /**
     * 获取所有未分配订单
     * @return
     */
    List<UnsettledOrder> getAllUOrder();

    /**
     * 删除订单
     * @param orderId
     */
    void deleteUOrder(String orderId);

    /**
     * 获取特定城市特定类型的司机集合
     * @param city
     * @param type
     * @return
     */
    Set<String> getHashByPattern(String city, int type);

    /**
     * 更新分配的订单
     * @param driverId
     * @param dispatchedOrders
     */
    void updateDispatch(String driverId, List<UnsettledOrder> dispatchedOrders);

    /**
     * 更新分配的订单
     * @param driverId
     * @param dispatchedOrder
     */
    void updateDispatch(String driverId, UnsettledOrder dispatchedOrder);

    /**
     * 获取分配到的订单
     * @param driverId
     * @return
     */
    List<UnsettledOrder> getDispatch(String driverId);

    /**
     * 删除一个司机的所有订单
     * @param driverId
     */
    void clearDispatch(String driverId);

    /**
     * 为特定司机删除特定的订单
     * @param driverId
     * @param orderId
     * @return
     */
    Boolean deleteDispatch(String driverId, String orderId);

    /**
     * 更新时间排序集合
     * @param orderId
     * @param driverId
     * @param duration
     */
    void updateDurationSet(String orderId, String driverId, double duration);

    /**
     * 清空时间排序集合
     * @param orderId
     * @param driverId
     */
    void clearDurationSet(String orderId, String driverId);

    /**
     * 获得所有时间排序集合key
     * @return
     */
    Set<String> getAllDurationSetKeys();

    /**
     * 清空所有时间集合
     */
    void deleteDurationSets(Set<String> keys);

    /**
     * 获取订单分配司机表
     * @param orderId
     * @return
     */
    Set<String> getDriverIdByRank(String orderId);

    /**
     * 尝试接受订单
     * @param orderId
     * @param driverId
     * @return
     */
    Boolean acceptOrder(String orderId, String driverId);
}
