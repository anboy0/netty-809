package com.unicom.netty809.util.response;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Desc: 返回值包装 实现类
 * @author:zhengs
 * @Time: 18-12-29 上午9:05
 * @param null
 * @return
 */
public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        ResponseData responseData = null;
        if (returnValue instanceof IResponseStatus) {
            responseData = new ResponseData((IResponseStatus) returnValue);
        } else if(returnValue instanceof ResponseData) {
        	responseData = (ResponseData) returnValue;
        }else{
            responseData = new ResponseData(returnValue, CommonStatus.OK);
        }
        delegate.handleReturnValue(responseData, returnType, mavContainer, webRequest);
    }
}