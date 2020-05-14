package com.unicom.netty809.tms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.unicom.netty809.tms.pojo.dto.PageDto;
import com.unicom.netty809.util.response.CommonStatus;
import com.unicom.netty809.util.response.IResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.unicom.netty809.tms.pojo.entity.DeviceRegisterEntity;
import com.unicom.netty809.tms.service.IDeviceRegisterService ;


/**
* TMS 设备登记 控制器
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@RequestMapping("/jt")
@RestController
@Api(tags = "TMS 设备登记管理", description = "TMS 设备登记管理相关设置API")
public class DeviceRegisterController {
    @Autowired
    IDeviceRegisterService deviceRegisterService;

	@GetMapping(value = "/deviceregisters/{id}")
	@ApiOperation("根据ID查询TMS 设备登记")
	public DeviceRegisterEntity queryById(@ApiParam("部门ID") @PathVariable("id") Integer id) {
		return deviceRegisterService.selectById(id);
	}

	@GetMapping(value = "/deviceregisters")
	@ApiOperation("分页查询TMS 设备登记")
	public Page<DeviceRegisterEntity> queryPageList(@ModelAttribute PageDto dto) {
		Wrapper<DeviceRegisterEntity> wrapper = new EntityWrapper<DeviceRegisterEntity>();
		return deviceRegisterService.selectPage(new Page<DeviceRegisterEntity>(dto.getPage(), dto.getPageSize()), wrapper);
	}

    @PostMapping(value = "/deviceregisters")
    @ApiOperation("新增TMS 设备登记")
    public IResponseStatus add(@RequestBody DeviceRegisterEntity entity) {
        deviceRegisterService.insert(entity);

        return CommonStatus.ADD_OK;
    }

    @PutMapping(value = "/deviceregisters/{id}")
    @ApiOperation("修改TMS 设备登记")
    public IResponseStatus update(@RequestBody DeviceRegisterEntity entity) {
        deviceRegisterService.updateById(entity);

        return CommonStatus.UPDATE_OK;
    }

    @DeleteMapping(value = "/deviceregisters/{id}")
    @ApiOperation("删除TMS 设备登记")
    public IResponseStatus del(@ApiParam("TMS 设备登记ID") @PathVariable("id") Integer id) {
        deviceRegisterService.deleteById(id);

        return CommonStatus.DELETE_OK;
    }


}
