package com.bridge.sys.service.impl;

import com.bridge.sys.pojo.RoutineDetectionItem;
import com.bridge.sys.mapper.RoutineDetectionItemMapper;
import com.bridge.sys.service.IRoutineDetectionItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class RoutineDetectionItemServiceImpl extends ServiceImpl<RoutineDetectionItemMapper, RoutineDetectionItem> implements IRoutineDetectionItemService {

    @Autowired
    private RoutineDetectionItemMapper routineDetectionItemMapper;

    @Override
    public List<RoutineDetectionItem> getAllRoutineDetectionItems() {
        return routineDetectionItemMapper.selectList(null);
    }
}
