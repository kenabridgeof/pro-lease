package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.atguigu.service.impl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
