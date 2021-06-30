package com.bridge.sys.service.impl;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.mapper.RoutineDetectionResultMapper;
import com.bridge.sys.pojo.RoutineDetection;
import com.bridge.sys.mapper.RoutineDetectionMapper;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.service.IRoutineDetectionResultService;
import com.bridge.sys.service.IRoutineDetectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class RoutineDetectionServiceImpl extends ServiceImpl<RoutineDetectionMapper, RoutineDetection> implements IRoutineDetectionService {


}
