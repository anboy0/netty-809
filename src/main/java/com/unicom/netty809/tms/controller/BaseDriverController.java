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

import com.unicom.netty809.tms.pojo.entity.BaseDriverEntity;
import com.unicom.netty809.tms.service.IBaseDriverService ;


/**
*  控制器
* @author:zengshuai
* @Time: 2020-05-13
* @Copyright: ©  杭州凯立通信有限公司 版权所有
* @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
*/
@RequestMapping("/{api_version}")
@RestController
@Api(tags = "管理", description = "管理相关设置API")
public class BaseDriverController{
    @Autowired
    IBaseDriverService baseDriverService;

	@GetMapping(value = "/basedrivers/{id}")
	@ApiOperation("根据ID查询")
	public BaseDriverEntity queryById(@ApiParam("部门ID") @PathVariable("id") Integer id) {
		return baseDriverService.selectById(id);
	}

	@GetMapping(value = "/basedrivers")
	@ApiOperation("分页查询")
	public Page<BaseDriverEntity> queryPageList(@ModelAttribute PageDto dto) {
		Wrapper<BaseDriverEntity> wrapper = new EntityWrapper<BaseDriverEntity>();
		return baseDriverService.selectPage(new Page<BaseDriverEntity>(dto.getPage(), dto.getPageSize()), wrapper);
	}

    @PostMapping(value = "/basedrivers")
    @ApiOperation("新增")
    public IResponseStatus add(@RequestBody BaseDriverEntity entity) {
        baseDriverService.insert(entity);

        return CommonStatus.ADD_OK;
    }

    @PutMapping(value = "/basedrivers/{id}")
    @ApiOperation("修改")
    public IResponseStatus update(@RequestBody BaseDriverEntity entity) {
        baseDriverService.updateById(entity);

        return CommonStatus.UPDATE_OK;
    }

    @DeleteMapping(value = "/basedrivers/{id}")
    @ApiOperation("删除")
    public IResponseStatus del(@ApiParam("ID") @PathVariable("id") Integer id) {
        baseDriverService.deleteById(id);

        return CommonStatus.DELETE_OK;
    }

}
