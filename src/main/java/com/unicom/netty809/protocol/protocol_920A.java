package com.unicom.netty809.protocol;

import com.unicom.netty809.client.JT809Constants;
import com.unicom.netty809.config.SpringContextHolder;
import com.unicom.netty809.protocolBody.JT_120A;
import com.unicom.netty809.protocolBody.JT_920A;
import com.unicom.netty809.tms.pojo.entity.BaseDriverEntity;
import com.unicom.netty809.tms.service.IBaseDriverService;
import com.unicom.netty809.util.HexStringUtils;
import com.unicom.netty809.util.Util;
import com.unicom.netty809.vomodel.Message;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.MessageEvent;

import java.nio.charset.Charset;


/**
 * @Desc: 上报车辆驾驶员身份识别信息应答
 * @author: zengshuai
 * @Time: 20-5-11 下午3:49
 * @Copyright: © 2018 杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
public class protocol_920A implements ProtocolHandler{

    @Override
    public void handlerMsg(Message msg, MessageEvent e, String vehicleNo, byte vehicleColor, int dataType,
            long dataLength) {

        logger.info("上报车辆驾驶员身份识别信息请求==="+msg.toString());

        JT_920A jt920A = new JT_920A();
        jt920A.setVehicleNo(vehicleNo);
        jt920A.setVehicleColor(vehicleColor);
        jt920A.setDataType(dataType);
        jt920A.setDataLength(dataLength);

        //发送消息
        Message msgRep = new Message(JT809Constants.DOWN_EXG_MSG);
        ChannelBuffer buffer = ChannelBuffers.buffer(28);
        buffer.writeBytes(HexStringUtils.getBytesWithLengthAfter(21,jt920A.getVehicleNo().getBytes(Charset.forName("GBK"))));
        buffer.writeByte(jt920A.getVehicleColor());
        buffer.writeShort(dataType);
        buffer.writeInt((int)dataLength);
        msgRep.setMsgBody(buffer);
        ChannelFuture f = e.getChannel().write(msgRep);

    }
}
