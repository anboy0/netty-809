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

import com.unicom.netty809.tms.pojo.entity.DeviceRuleEntity;
import com.unicom.netty809.tms.service.IDeviceRuleService ;


/**
* TMS 设备管理 控制器
* @author:zengshuai
* @Time: 2020-04-14
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@RequestMapping("/{api_version}")
@RestController
@Api(tags = "TMS 设备管理管理", description = "TMS 设备管理管理相关设置API")
public class DeviceRuleController{
    @Autowired
    IDeviceRuleService deviceRuleService;

	@GetMapping(value = "/devicerules/{id}")
	@ApiOperation("根据ID查询TMS 设备管理")
	public DeviceRuleEntity queryById(@ApiParam("部门ID") @PathVariable("id") Integer id) {
		return deviceRuleService.selectById(id);
	}

	@GetMapping(value = "/devicerules")
	@ApiOperation("分页查询TMS 设备管理")
	public Page<DeviceRuleEntity> queryPageList(@ModelAttribute PageDto dto) {
		Wrapper<DeviceRuleEntity> wrapper = new EntityWrapper<DeviceRuleEntity>();
		return deviceRuleService.selectPage(new Page<DeviceRuleEntity>(dto.getPage(), dto.getPageSize()), wrapper);
	}

    @PostMapping(value = "/devicerules")
    @ApiOperation("新增TMS 设备管理")
    public IResponseStatus add(@RequestBody DeviceRuleEntity entity) {
        deviceRuleService.insert(entity);

        return CommonStatus.ADD_OK;
    }

    @PutMapping(value = "/devicerules/{id}")
    @ApiOperation("修改TMS 设备管理")
    public IResponseStatus update(@RequestBody DeviceRuleEntity entity) {
        deviceRuleService.updateById(entity);

        return CommonStatus.UPDATE_OK;
    }

    @DeleteMapping(value = "/devicerules/{id}")
    @ApiOperation("删除TMS 设备管理")
    public IResponseStatus del(@ApiParam("TMS 设备管理ID") @PathVariable("id") Integer id) {
        deviceRuleService.deleteById(id);

        return CommonStatus.DELETE_OK;
    }

}
