package com.unicom.netty809.protocol;

import com.unicom.netty809.vomodel.Message;
import org.jboss.netty.channel.MessageEvent;

import java.util.logging.Logger;

/**
 * @Desc: 协议通用接口
 * @author: zengshuai
 * @Time: 20-5-11 下午3:45
 * @Copyright: © 2018 杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
public interface ProtocolHandler {

    Logger logger = Logger.getLogger("ProtocolHandler==");
    void handlerMsg(Message msg,MessageEvent e,String vehicleNo,byte vehicleColor,int dataType,long dataLength);

}
