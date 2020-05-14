package com.unicom.netty809.tms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unicom.netty809.tms.pojo.entity.DeviceRegisterEntity;
import com.unicom.netty809.tms.service.IDeviceRegisterService ;
import com.unicom.netty809.tms.mapper.DeviceRegisterMapper;

/**
* TMS 设备登记 service实现类
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceRegisterServiceImpl extends ServiceImpl<DeviceRegisterMapper, DeviceRegisterEntity>  implements IDeviceRegisterService {

}
