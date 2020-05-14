package com.unicom.netty809.protocol;

import com.unicom.netty809.config.SpringContextHolder;
import com.unicom.netty809.protocolBody.JT_120A;
import com.unicom.netty809.tms.pojo.entity.BaseDriverEntity;
import com.unicom.netty809.tms.service.IBaseDriverService;
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
public class protocol_120A implements ProtocolHandler{

    @Override
    public void handlerMsg(Message msg, MessageEvent e, String vehicleNo, byte vehicleColor, int dataType,
            long dataLength) {

        logger.info("上报驾驶员身份识别信息==="+msg.toString());
        IBaseDriverService deviceRegisterService = (IBaseDriverService) SpringContextHolder.getBean("BaseDriverServiceImpl");

        ChannelBuffer childBody = msg.getMsgBody().readBytes((int)dataLength);

        String driverName = new String(childBody.readBytes(16).array(), Charset.forName("GBK"));
        String driverId = new String(childBody.readBytes(20).array(), Charset.forName("GBK"));
        String licence = new String(childBody.readBytes(40).array(), Charset.forName("GBK"));
        String orgName = new String(childBody.readBytes(200).array(), Charset.forName("GBK"));

        JT_120A jt120A = new JT_120A();
        jt120A.setDriverName(driverName);
        jt120A.setDriverId(driverId);
        jt120A.setLicence(licence);
        jt120A.setOrgName(orgName);

        BaseDriverEntity entity = new BaseDriverEntity();
        entity.setDriverId(Integer.valueOf(jt120A.getDriverId()));
        entity.setDriverName(jt120A.getDriverName());
        entity.setDriveLicense(jt120A.getLicence());
        deviceRegisterService.insert(entity);

        //消息应答报文回复接收成功 Id=1006
        Message msgRep = new Message(4102);
        ChannelBuffer buffer = ChannelBuffers.buffer(0);
        msgRep.setMsgBody(buffer);
        ChannelFuture f = e.getChannel().write(msgRep);

    }
}
