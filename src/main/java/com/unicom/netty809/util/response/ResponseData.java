package com.unicom.netty809.util.response;


/**
 * @Desc: 返回值 对象类型
 * @author:zhengs
 * @Time: 19-1-24 下午4:03
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
public class ResponseData<T> {

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;


    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData() {

    }

    public ResponseData(IResponseStatus status) {
        this.status = status.status();
        this.message = status.message();
    }

    public ResponseData(T data, IResponseStatus status) {
        this.data = data;
        this.status = status.status();
        this.message = status.message();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}