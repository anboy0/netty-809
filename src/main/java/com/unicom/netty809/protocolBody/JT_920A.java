package com.unicom.netty809.protocolBody;


import lombok.Data;

/**
 * @Desc: 上报车辆驾驶员身份识别信息请求
 * @author: zengshuai
 * @Time: 20-5-13 下午2:36
 * @Copyright: © 2018 杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@Data
public class JT_920A {

    private String vehicleNo;

    private byte vehicleColor;

    private int dataType;

    private long dataLength;

}
