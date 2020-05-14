package com.unicom.netty809.tms.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc: 公共entity
 * @author:zhengs
 * @Time: 18-12-29 上午9:11
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
@Data
public class BaseEntity implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人",hidden = true)
    public String createBy;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间",hidden = true)
    public Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改人",hidden = true)
    public String modifyBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间",hidden = true)
    public Date modifyTime;
}
