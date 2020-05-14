package com.unicom.netty809.protocolBody;

import lombok.Data;

/**
 * @Desc: 120A协议
 * @author: zengshuai
 * @Time: 20-5-12 下午4:03
 * @Copyright: © 2018 杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@Data
public class JT_120A{

    // 驾驶员姓名
    private String driverName;

    //身份证编号
    private String driverId;

    //从业资格证(备用)
    private String licence;

    //发证机构名称(备用)
    private String orgName;

}
