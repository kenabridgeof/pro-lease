package com.atguigu.lease.web.admin.service.impl;

import com.atguigu.lease.model.entity.SystemPost;
import com.atguigu.lease.model.entity.SystemUser;
import com.atguigu.lease.web.admin.mapper.SystemPostMapper;
import com.atguigu.lease.web.admin.mapper.SystemUserMapper;
import com.atguigu.lease.web.admin.service.SystemUserService;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liubo
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemPostMapper systemPostMapper;

    @Override
    public void saveOrUpdateSystemUser(SystemUser systemUser) {
        boolean isSave = systemUser.getId() == null;
        if (isSave) {
            String password = systemUser.getPassword();
            String hashedPassword = DigestUtils.sha256Hex(password);
            systemUser.setPassword(hashedPassword);
            systemUserMapper.insert(systemUser);
        } else {
            if (systemUser.getPassword() != null) {
                String hashedPassword = DigestUtils.sha256Hex(systemUser.getPassword());
                systemUser.setPassword(hashedPassword);
            }
            systemUserMapper.updateById(systemUser);
        }
    }

    @Override
    public IPage<SystemUserItemVo> pageItem(IPage<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageItem(page, queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {

        SystemUser systemUser = systemUserMapper.selectById(id);
        systemUser.setPassword(null);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());


        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemUser, systemUserItemVo);

        systemUserItemVo.setPostName(systemPost.getName());

        return systemUserItemVo;
    }
}




