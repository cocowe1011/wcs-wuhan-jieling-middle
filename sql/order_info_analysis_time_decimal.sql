-- 解析时间改为支持一位小数（小时）
-- 已有库升级脚本：将 order_info.analysis_time 从 INT 改为 DECIMAL(10,1)

IF EXISTS (
    SELECT 1
    FROM sys.columns
    WHERE object_id = OBJECT_ID(N'dbo.order_info')
      AND name = N'analysis_time'
)
BEGIN
    ALTER TABLE dbo.order_info
        ALTER COLUMN analysis_time DECIMAL(10,1) NULL;
END
GO
