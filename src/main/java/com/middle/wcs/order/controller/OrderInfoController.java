package com.middle.wcs.order.controller;

import com.github.pagehelper.PageInfo;
import com.middle.wcs.hander.ResponseResult;
import com.middle.wcs.order.entity.dto.OrderInfoPageDTO;
import com.middle.wcs.order.entity.po.OrderInfo;
import com.middle.wcs.order.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (OrderInfo)控制器
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */

@Api(tags = "订单管理接口")
@RestController
@RequestMapping("/order_info")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;
    
    @ApiOperation("保存订单信息")
    @PostMapping("/save")
    public ResponseResult<Integer> save(@ApiParam(value = "订单信息", required = true) @RequestBody OrderInfo po) {
        return ResponseResult.success(this.orderInfoService.save(po));
    }
    
    @ApiOperation("更新订单信息")
    @PostMapping("/update")
    public ResponseResult<Integer> update(@ApiParam(value = "订单信息", required = true) @RequestBody OrderInfo po) {
        return ResponseResult.success(this.orderInfoService.update(po));
    }

    @ApiOperation("根据ID查询订单信息")
    @GetMapping("/getOrderInfoById")
    public ResponseResult<OrderInfo> getOrderInfoById(@ApiParam(value = "订单ID", required = true) Long id) {
        return ResponseResult.success(this.orderInfoService.getOrderInfoById(id));
    }

    @ApiOperation("通过批号查询订单信息")
    @GetMapping("/getOrderInfoByBatchNo")
    public ResponseResult<OrderInfo> getOrderInfoByBatchNo(@ApiParam(value = "批号", required = true) String batchNo) {
        return ResponseResult.success(this.orderInfoService.getOrderInfoByBatchNo(batchNo));
    }

    @ApiOperation("执行订单")
    @PostMapping("/executeOrder")
    public ResponseResult<Integer> executeOrder(@ApiParam(value = "订单执行信息", required = true) @RequestBody OrderInfo po) {
        return ResponseResult.success(this.orderInfoService.executeOrder(po));
    }

    @ApiOperation("查询订单列表-正在执行和待执行的")
    @PostMapping("/queryOrderList")
    public ResponseResult<List<OrderInfo>> queryOrderList() {
        return ResponseResult.success(this.orderInfoService.queryOrderList());
    }

    @ApiOperation("查询订单-正在执行")
    @PostMapping("/getNowRunningOrder")
    public ResponseResult<OrderInfo> getNowRunningOrder() {
        return ResponseResult.success(this.orderInfoService.getNowRunningOrder());
    }



    /**
     * 查询历史订单信息列表
     * @return 出参
     */
    @ApiOperation("查询历史订单信息列表")
    @PostMapping("/queryHistoryOrderList")
    public ResponseResult<PageInfo<OrderInfo>> queryHistoryOrderList(@RequestBody OrderInfoPageDTO dto) {
        return ResponseResult.success(this.orderInfoService.queryHistoryOrderList(dto));
    }

    /**
     * 入参查询
     * @param dto 入参
     * @return 出参
     */
    @ApiOperation("入参查询")
    @PostMapping("/selectByList")
    public ResponseResult<List<OrderInfo>> selectByList(@RequestBody OrderInfo dto) {
        return ResponseResult.success(this.orderInfoService.selectByList(dto));
    }
}
