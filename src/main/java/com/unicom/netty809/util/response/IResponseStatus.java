package com.unicom.netty809.util.response;

/**
 * @Desc: 响应码接口
 * @author:zhengs
 * @Time: 18-12-29 上午9:05
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
public interface IResponseStatus {
    /**
    * 响应码
    * @author:zhengs
    * @Time: 19-1-24 上午9:15
    *
    * @return
    */
    int status();

    /**
    * 响应内容
    * @author:zhengs
    * @Time: 19-1-24 上午9:16
    *
    * @return
    */
    String message();
}