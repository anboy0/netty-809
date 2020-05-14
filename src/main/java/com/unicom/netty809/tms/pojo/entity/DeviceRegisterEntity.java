package com.unicom.netty809.tms.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* TMS 设备登记 entity
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@Data
@TableName("tms_device_register")
public class DeviceRegisterEntity {
	@TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("终端号（唯一标识）")
    private String terminalId;

    @ApiModelProperty("终端厂家ID（关联数据字典中ID）")
    private Integer terminalFactoryId;

    @ApiModelProperty("终端型号")
    private String terminalType;

    @ApiModelProperty("硬件版本号")
    private String hardwareVersion;

    @ApiModelProperty("固件版本号")
    private String solidVersion;

    @ApiModelProperty("SIM卡号")
    private String simNumber;

    @ApiModelProperty("鉴权值（生成8位随机数）")
    private String authValue;

    @ApiModelProperty("数据状态（0：删除 1：正常）")
    private String rdStatus;

    @ApiModelProperty("设备状态（0禁用 1启用）")
    private String status;

    @ApiModelProperty("所属部门")
    private Integer departmentId;

    @ApiModelProperty("创建人")
    private Integer createdBy;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("修改人")
    private Integer modifiedBy;

    @ApiModelProperty("修改时间")
    private Date modifiedTime;

    @ApiModelProperty("公司编码")
    private String companyCode;

}
