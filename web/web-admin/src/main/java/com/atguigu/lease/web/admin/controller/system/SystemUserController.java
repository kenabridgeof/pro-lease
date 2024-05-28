package com.atguigu.lease.web.admin.controller.system;


import com.atguigu.lease.common.annotation.CheckPermission;
import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.SystemUser;
import com.atguigu.lease.model.enums.BaseStatus;
import com.atguigu.lease.web.admin.service.SystemUserService;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "后台用户信息管理")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService service;

    //@CheckPermission
    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {
        service.saveOrUpdateSystemUser(systemUser);
        return Result.ok();
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam(required = false) Long id, @RequestParam String username) {
        LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(id != null, SystemUser::getId, id);
        queryWrapper.eq(SystemUser::getUsername, username);
        long count = service.count(queryWrapper);
        return Result.ok(count == 0);
    }

    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        IPage<SystemUser> page = new Page<>(current, size);
        IPage<SystemUserItemVo> list = service.pageItem(page,queryVo);
        return Result.ok(list);
    }

    @CheckPermission
    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo user = service.getSystemUserById(id);
        return Result.ok(user);
    }

    @CheckPermission
    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemUser> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(SystemUser::getId, id);
        queryWrapper.set(SystemUser::getStatus, status);
        service.update(queryWrapper);
        return Result.ok();
    }
}
