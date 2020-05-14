package com.unicom.netty809.util.db;

import com.alibaba.druid.util.DruidPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

/**
 * @Desc: 数据库密码解密回调方法
 * @author:zhengs
 * @Time: 18-12-29 上午8:55
 * @param
 * @return
 */
public class DbPasswordCallback extends DruidPasswordCallback {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        String password = (String) properties.get("password");

        try {
            setPassword(DbUtil.druidDecrypt(password).toCharArray());
        } catch (Exception e) {
            logger.error("Druid CommonUtil.druidDecrypt", e);
        }
    }
}