package com.middle.wcs.order.entity.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * (OrderInfo)实体类
 *
 * @author makejava
 * @since 2024-12-28 23:59:48
 */
@Data
@TableName("order_info")
public class OrderInfo {
    /**
    * 主键
    */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
    * 订单编号
    */
    private String orderId;

    /**
    * 订单名称
    */
    private String orderName;

    /**
    * 批号
    */
    private String batchNo;

    /**
    * 产品名称
    */
    private String productName;

    /**
    * 工艺名称
    */
    private String processName;

    /**
    * 订单数量
    */
    private Integer orderQuantity;

    /**
    * 目的地（选中订单执行时设定，编号19~33）
    */
    private String destination;

    /**
    * 解析时间（单位：小时，支持一位小数，选中订单执行时设定）
    */
    private Double analysisTime;

    /**
    * 订单状态：0=未开始、1=执行中、2=已完成
    */
    private Integer orderStatus;

    /**
    * 已上货数量（每次设置执行订单时清零）
    */
    private Integer loadedQuantity;

    /**
    * 订单创建时间（数据库默认当前时间）
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 作废标志：0=未作废、1=已作废
     */
    private Integer invalidFlag;

    /**
     * 添加订单的用户姓名
     */
    private String createrName;

    /**
     * 添加订单的用户code编号
     */
    private String createrCode;

    /**
     * 订单执行人姓名
     */
    private String executorName;

    /**
     * 订单执行人code编号
     */
    private String executorCode;

    /**
     * 订单完成人姓名
     */
    private String finisherName;

    /**
     * 订单完成人code编号
     */
    private String finisherCode;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishTime;
}
