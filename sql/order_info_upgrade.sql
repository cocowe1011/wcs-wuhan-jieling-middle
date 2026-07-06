CREATE TABLE dbo.order_info (
    id              BIGINT           NOT NULL PRIMARY KEY,
    order_id        NVARCHAR(100)    NULL,
    order_name      NVARCHAR(200)    NULL,
    batch_no        NVARCHAR(100)    NULL,
    product_name    NVARCHAR(200)    NULL,
    process_name    NVARCHAR(200)    NULL,
    order_quantity  INT              NULL,
    destination     NVARCHAR(50)     NULL,
    analysis_time   INT              NULL,
    order_status    TINYINT          NULL DEFAULT 0,
    loaded_quantity INT              NULL DEFAULT 0,
    create_time     DATETIME         NULL DEFAULT GETDATE(),
    invalid_flag    TINYINT          NULL DEFAULT 0,
    creater_name    NVARCHAR(50)     NULL,
    creater_code    NVARCHAR(50)     NULL,
    executor_name   NVARCHAR(50)     NULL,
    executor_code   NVARCHAR(50)     NULL,
    finisher_name   NVARCHAR(50)     NULL,
    finisher_code   NVARCHAR(50)     NULL,
    finish_time     DATETIME         NULL
);
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主键ID',           @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单编号',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'order_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单名称',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'order_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'批号',             @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'batch_no';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品名称',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'product_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工艺名称',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'process_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单数量',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'order_quantity';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'目的地（编号19~33）', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'destination';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'解析时间（单位：小时）', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'analysis_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单状态：0=未开始、1=执行中、2=已完成', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'order_status';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'已上货数量（每次执行订单时清零）', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'loaded_quantity';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单创建时间',     @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'create_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'作废标志：0=未作废、1=已作废', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'invalid_flag';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'添加订单的用户姓名',   @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'creater_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'添加订单的用户code编号', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'creater_code';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单执行人姓名',   @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'executor_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单执行人code编号', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'executor_code';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单完成人姓名',   @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'finisher_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单完成人code编号', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'finisher_code';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'完成时间',         @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'order_info', @level2type=N'COLUMN', @level2name=N'finish_time';
GO
