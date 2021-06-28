package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bridge.sys.mapper.NavMapper;
import com.bridge.sys.pojo.Nav;
import com.bridge.sys.service.INavService;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class NavServiceImpl extends ServiceImpl<NavMapper, Nav> implements INavService {
}
