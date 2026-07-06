package com.middle.wcs.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.middle.wcs.order.entity.dto.OrderInfoPageDTO;
import com.middle.wcs.order.entity.po.OrderInfo;
import com.middle.wcs.order.dao.OrderInfoMapper;
import com.middle.wcs.order.service.OrderInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;

/**
 * (OrderInfo)服务实现类
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    
    @Resource
    private OrderInfoMapper orderInfoMapper;
    
    @Override
    public Integer save(OrderInfo orderInfo) {
        return orderInfoMapper.insert(orderInfo);
    }
    
    @Override
    public Integer update(OrderInfo orderInfo) {
        return orderInfoMapper.updateById(orderInfo);
    }
    
    @Override
    public OrderInfo getOrderInfoById(Long id) {
        return orderInfoMapper.selectById(id);
    }
    
    @Override
    public List<OrderInfo> queryOrderList() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag(0);
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.ne("order_status", 2);
        wrapper.orderByDesc("order_status").orderByAsc("create_time");
        return orderInfoMapper.selectList(wrapper);
    }

    @Override
    public PageInfo<OrderInfo> queryHistoryOrderList(OrderInfoPageDTO dto) {
        // 分页查询当前时段的预约患者
        Page<OrderInfo> page = startPage(dto.getPageNum(), dto.getPageSize());
        orderInfoMapper.queryHistoryOrderList(dto);
        PageInfo<OrderInfo> voPage = new PageInfo<>(page);
        return voPage;
    }

    @Override
    public OrderInfo getNowRunningOrder() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag(0);
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.eq("order_status", 1);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
        if (orderInfos != null && orderInfos.size() > 0) {
            return orderInfos.get(0);
        }
        return null;
    }

    @Override
    public OrderInfo getOrderInfoByBatchNo(String batchNo) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setInvalidFlag(0);
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(orderInfo);
        wrapper.eq("batch_no", batchNo);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
        if (orderInfos != null && orderInfos.size() > 0) {
            return orderInfos.get(0);
        }
        return null;
    }

    @Override
    public Integer executeOrder(OrderInfo orderInfo) {
        // 执行订单：清零已上货数量，状态改为执行中
        orderInfo.setLoadedQuantity(0);
        orderInfo.setOrderStatus(1);
        return orderInfoMapper.updateById(orderInfo);
    }

    @Override
    public List<OrderInfo> selectByList(OrderInfo dto) {
        QueryWrapper<OrderInfo> wrapper= new QueryWrapper<>(dto);
        return this.orderInfoMapper.selectList(wrapper);
    }
}
