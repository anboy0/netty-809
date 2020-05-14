package com.unicom.netty809.tms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.unicom.netty809.tms.pojo.entity.DeviceRegisterEntity;

/**
* TMS 设备登记 mapper
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@Mapper
public interface DeviceRegisterMapper extends BaseMapper<DeviceRegisterEntity> {

}
