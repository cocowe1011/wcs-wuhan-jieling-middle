package com.middle.wcs.order.service;

import com.middle.wcs.order.entity.dto.OrderInfoPageDTO;
import com.middle.wcs.order.entity.po.OrderInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * (OrderInfo)服务接口
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */
public interface OrderInfoService {
    
    /**
     * 保存订单信息
     *
     * @param orderInfo 订单信息
     */
    Integer save(OrderInfo orderInfo);
    
    /**
     * 更新订单信息
     *
     * @param orderInfo 订单信息
     */
    Integer update(OrderInfo orderInfo);
    
    /**
     * 根据id查询订单信息
     *
     * @param id 订单id
     * @return 订单信息
     */
    OrderInfo getOrderInfoById(Long id);
    
    /**
     * 根据条件查询订单列表
     *
     * @return 订单列表
     */
    List<OrderInfo> queryOrderList();

    PageInfo<OrderInfo> queryHistoryOrderList(OrderInfoPageDTO dto);

    OrderInfo getNowRunningOrder();

    OrderInfo getOrderInfoByBatchNo(String batchNo);

    /**
     * 执行订单：设置目的地、解析时间，清零已上货数量，状态改为执行中，记录执行人
     *
     * @param orderInfo 订单信息（含id、destination、analysisTime、executorName、executorCode）
     * @return 更新结果
     */
    Integer executeOrder(OrderInfo orderInfo);

    List<OrderInfo> selectByList(OrderInfo dto);
}
