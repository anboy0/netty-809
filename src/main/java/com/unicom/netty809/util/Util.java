package com.unicom.netty809.util;
/**
    转16进制
*/
public class Util {
    public static int crc16(byte[]... bytesArr) {
//        int b = 0;
//        int crc = 0xffff;    //初始值
//
//        for (byte[] d : bytesArr) {
//            for (int i = 0; i < d.length; i++) {
//                for (int j = 0; j < 8; j++) {
//                    b = ((d[i] << j) & 0x80) ^ ((crc & 0x8000) >> 8);
//                    crc <<= 1;
//                    if (b != 0)
//                        crc ^= 0x1021;      //校验公式
//                }
//            }
//        }
//        crc = ~crc;
//        return crc;

//        byte[] bytes = bytesArr[0];
//        int crc = 0xFFFF;
//        for (int j = 0; j < bytes.length ; j++) {
//            crc = ((crc  >>> 8) | (crc  << 8) )& 0xffff;
//            crc ^= (bytes[j] & 0xff);//byte to int, trunc sign
//            crc ^= ((crc & 0xff) >> 4);
//            crc ^= (crc << 12) & 0xffff;
//            crc ^= ((crc & 0xFF) << 5) & 0xffff;
//        }
//        crc &= 0xffff;
//        return crc;

        int crc = 0xFFFF;
        for (byte[] bytes : bytesArr) {
            for (int j = 0; j < bytes.length; j++) {
                crc = ((crc >>> 8) | (crc << 8)) & 0xffff;
                crc ^= (bytes[j] & 0xff);//byte to int, trunc sign
                crc ^= ((crc & 0xff) >> 4);
                crc ^= (crc << 12) & 0xffff;
                crc ^= ((crc & 0xFF) << 5) & 0xffff;
            }
        }
        crc &= 0xffff;
        return crc;
    }

}
