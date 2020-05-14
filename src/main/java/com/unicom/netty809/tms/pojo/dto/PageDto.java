package com.unicom.netty809.tms.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Desc:分页Dto
 * @author:zhengs
 * @Time: 19-1-23 下午1:51
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
@Data
@ApiModel("分页Dto")
public class PageDto {
    @ApiModelProperty("当前页数")
    private int page = 1;

    @ApiModelProperty("每一页显示的条数")
    private int pageSize = 10;
}
