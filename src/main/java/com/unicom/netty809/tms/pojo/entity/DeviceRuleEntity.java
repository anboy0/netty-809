package com.unicom.netty809.tms.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
* TMS 设备管理 entity
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@Data
@TableName("tms_device_rule")
public class DeviceRuleEntity  {
	@TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("终端号（唯一标识）")
    private String terminalId;

    @ApiModelProperty("设备状态(0禁用  1启用)")
    private String status;

    @ApiModelProperty("鉴权成功:0 正常在线:1")
    private String aucStatus;

    @ApiModelProperty("在线状态(0离线   1在线)")
    private String onlineStatus;

    @ApiModelProperty("设备电量")
    private String deviceCharge;

    @ApiModelProperty("监控温度")
    private String monitorTemper;

    @ApiModelProperty("监控湿度")
    private String monitorDity;

    @ApiModelProperty("里程")
    private Float mileage;

    @ApiModelProperty("经度")
    private BigDecimal longitude;

    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    @ApiModelProperty("定位地址")
    private String address;

    @ApiModelProperty("数据更新时间")
    private Date updateTime;

    @ApiModelProperty("所属部门")
    private Integer departmentId;

    @ApiModelProperty("备注")
    private String remark;

}
