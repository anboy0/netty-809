package com.unicom.netty809.vomodel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by liujiawei on 2019-03-11.
 * 车辆注册信息类
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UpExgMsgRegisterEntity implements Serializable{

    /**
     *        主键
    */
    private Long id;

    /**
     *        数据长度
     */
    private long msgLength;

    /**
     *        报文序列号
     */
    private long msgSn;

    /**
     *        业务数据类型
     */
    private int msgId;

    /**
     *        下级平台接入码，上级平台给下级平台分配的唯一标识
     */
    private long msgGnsscenterId;

    /**
     *        协议版本号标识，上下级平台之间采用的标准协议版本编号；
     *        长度为三个字节来表示:0x01 0x02 0x0F 表示的版本号是V1.2.15，以此类推。
     */
    private String versionFlag;

    /**
     *        报文加密标志位：0 表示报文不加密，1 表示报文加密
     */
    private int encryptFlag;

    /**
     *        数据加密的密钥，长度为四个字节
     */
    private long encryptKey;


    /**
     *        车牌号
     */
    private String vehicleNo;

    /**
     *        车牌颜色，按照JT/T 415-2006中5.4.12的规定
     */
    private byte vehicleColor;

    /**
     *        子业务类型标识
     */
    private int dataType;

    /**
     * 后续数据长度
     */
    private long dataLength;

    //平台唯一编码
    private String platformId;

    //车载终端厂商唯一编码
    private String producerId;

    //车载终端型号，不是 8 位时以“\0” 终结
    private String terminalModelType;

    //车载终端编号，大写字母和数字组成
    private String terminalId;

    //车载终端 SIM 卡电话号码。号码不是 12 位，则在签补充数字 0.
    private String terminalSimCode;

    /**
     *        接口开发商
     */
    private String developer;

    /**
     *        原始报文
     */
    private Blob receiveData;

}
