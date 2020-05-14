package com.unicom.netty809.util.db;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @Desc: 数据库工具类
 * @author:zhengs
 * @Time: 18-12-28 下午3:51
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
public class DbUtil {
    /**
     * druid密码私钥
     */
    public static final String DRUID_PRIVATE_KEY = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEArGOsirHANBEo4pbOJQRzhXfSQYUNnCI/GF+ad1dJlYacgILo4OiXK6RY2pRTQ0ZmgvMhCt6vv8zHzXhXo7LNJwIDAQABAkAGOedebwMRHlmKrYWugpWliWlXonWWYQpEWBedHdLzioTcb/IWM7Jqf6m990NRA7vbKAXgTW84BekREovP2y/BAiEA5DVmVlO+JDs0ptodR13Oa00BleaRWSzgSNIUyyXp34cCIQDBYg+lPv54wiNQDfvUKsoxMPtGGsA/z+iXwEVHOrrNYQIhAKkM9bZVarEkOqivQqkvUE4kSVxl5J4OpEbNeSHUAB/ZAiB8Z0kJVOz/YmS1K0nFw4EvBAOhpbPnWSiX9uiaWf2yAQIhAKMBAEVrC22cUyrFaozpFy+8z92d3CBiJnDO3HDQ7d9O";

    /**
     * druid密码公钥
     */
    public static final String DRUID_PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJDU862hD23VirvvR16FBcWrsNUEuAu8/gV9/SPwd+pqD5Ii4dE5ipWnNHzZvUmfMkiEgIS/w8fJGnOqx1/VatkCAwEAAQ==";

    /**
     * druid密码解密回调方法
     */
    public static final String DRUID_PASSWORD_CALLBACK = "com.unicom.netty809.util.db.DbPasswordCallback";

    /**
     * 解密druid密码
     * @param password
     * @return
     */
    public static String druidDecrypt(String password){
        try {
            password = ConfigTools.decrypt(DRUID_PUBLIC_KEY, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return password;
    }

    /**
    * 根据公钥加密数据库密码
    * @author:zhengs
    * @Time: 19-1-24 下午5:03
    * @param password
    * @return
    */
    public static String druidEncrypt(String password){
        try {
            return ConfigTools.encrypt(DRUID_PRIVATE_KEY, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
    * 生成公钥\私钥\加密数据库密码
    * @author:zhengs
    * @Time: 19-1-24 下午5:03
    *
    * @return
    */
    public static void createKeyAndPassword(){
        String[] password = new String[]{"123456"};
        try {
            ConfigTools.main(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ////生成公钥\私钥\加密数据库密码
        createKeyAndPassword();

        //根据公钥加密数据库密码
        System.out.println(druidEncrypt("123456"));
    }
}
