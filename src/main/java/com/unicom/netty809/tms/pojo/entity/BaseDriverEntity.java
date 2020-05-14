package com.unicom.netty809.tms.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
*  entity
* @author:zengshuai
* @Time: 2020-05-13
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@Data
@TableName("base_driver")
public class BaseDriverEntity extends BaseEntity {
	@TableId(value = "driver_id", type = IdType.AUTO)
    @ApiModelProperty("驾驶员ID")
    private Integer driverId;

    @ApiModelProperty("驾驶员编号")
    private String driverCode;

    @ApiModelProperty("驾驶员名字")
    private String driverName;

    @ApiModelProperty("驾驶员性别")
    private Integer sex;

    @ApiModelProperty("驾驶证")
    private String driveLicense;

    @ApiModelProperty("车牌号")
    private String carNumber;

    @ApiModelProperty("驾照类型")
    private String driveType;

    @ApiModelProperty("电话")
    private String phoneNumber;

    @ApiModelProperty("所属网点ID")
    private Integer siteId;

    @ApiModelProperty("驾驶员地址")
    private String address;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("数据状态 0删除 1正常")
    private Integer rdStatus;

}
