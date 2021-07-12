package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.common.utils.UserUtil;
import com.bridge.sys.mapper.UserMapper;
import com.bridge.sys.pojo.BridgeInfo;
import com.bridge.sys.mapper.BridgeInfoMapper;
import com.bridge.sys.pojo.User;
import com.bridge.sys.pojo.vo.BridgeNameIdMapVo;
import com.bridge.sys.service.IBridgeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class BridgeInfoServiceImpl extends ServiceImpl<BridgeInfoMapper, BridgeInfo> implements IBridgeInfoService {

    @Autowired
    private BridgeInfoMapper bridgeInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserUtil userUtil;



    /**
     * 根据桥梁id查询桥梁信息
     * @param bridgeId
     * @return
     */
    @Override
    public BridgeInfo getBridgeInfoById(String bridgeId) {
        BridgeInfo bridgeInfo;
        try {
            bridgeInfo = bridgeInfoMapper.selectOne(new QueryWrapper<BridgeInfo>().eq("bridge_id", bridgeId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bridgeInfo;
    }

    /**
     * 建立桥梁资料卡
     * @param bridgeInfo
     * @param principal
     * @return
     */
    @Override
    public RespBean submitBridgeInfo(BridgeInfo bridgeInfo, Principal principal) {
        if (principal == null) {
            return RespBean.error("建立桥梁资料卡失败，权限不足");
        }
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>()
                    .eq("username", principal.getName()));
            if (user == null || user.getType() != 1) {
                return RespBean.error("建立桥梁资料卡失败，权限不足");
            }
            Integer total = bridgeInfoMapper.selectCount(null);
            bridgeInfo.setBridgeId(String.format("BI-%07d", total + 1));
            bridgeInfo.setTabulationDate(LocalDate.now());
            bridgeInfo.setUserId(user.getUserId());
            if (bridgeInfoMapper.insert(bridgeInfo) <= 0) {
                return RespBean.error("建立桥梁资料卡失败，插入数据库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("建立桥梁资料卡失败，插入数据库失败");
        }
        return RespBean.success("建立桥梁资料卡成功");
    }

    /**
     * 分页获取所有桥梁资料信息
     * @param current
     * @param size
     * @param bridgeName
     * @return
     */
    @Override
    public Page<BridgeInfo> getAllBridgeInfo(long current, long size, String bridgeName) {
        Page<BridgeInfo> bridgeInfoPage;
        try {
            bridgeInfoPage = bridgeInfoMapper.selectPage(new Page<BridgeInfo>(current, size, bridgeInfoMapper.selectCount(null)),
                    new QueryWrapper<BridgeInfo>().like(bridgeName != null && !bridgeName.equals(""), "bridge_name", bridgeName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bridgeInfoPage;
    }

    /**
     * 获取桥梁名称id键值对
     * @return
     */
    @Override
    public List<BridgeNameIdMapVo> getBridgeNameIdMap() {
        List<BridgeNameIdMapVo> bridgeNameIdMap;
        try {
            bridgeNameIdMap = bridgeInfoMapper.getBridgeNameIdMap();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bridgeNameIdMap;
    }

    /**
     * 根据桥梁名称模糊查询桥梁id
     * @param bridgeName
     * @return
     */
    @Override
    public List<BridgeNameIdMapVo> getVagueBridgeNameIdMap(String bridgeName) {
        List<BridgeNameIdMapVo> vagueBridgeNameIdMap;
        try {
            vagueBridgeNameIdMap = bridgeInfoMapper.getVagueBridgeNameIdMap(bridgeName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vagueBridgeNameIdMap;
    }

    /**
     * 根据桥梁id逻辑启用或弃用桥梁资料卡
     * @param bridgeId
     * @param principal
     * @return
     */
    @Override
    public RespBean deleteOrRecoverBridgeInfo(String bridgeId, Principal principal) {
        if (principal == null) {
            return RespBean.error("权限不足");
        }
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", principal.getName()));
            if (user == null || user.getType() >= 2) {
                return RespBean.error("权限不足");
            }
            BridgeInfo bridgeInfo = bridgeInfoMapper.selectOne(new QueryWrapper<BridgeInfo>().eq("bridge_id", bridgeId));
            int row;
            if (bridgeInfo.getDeleted() == true) {
                row = bridgeInfoMapper.recoverBridgeInfo(bridgeId);
            } else {
                row = bridgeInfoMapper.deleteBridgeInfoLogical(bridgeId);
            }
            if (row <= 0) {
                return RespBean.error("修改桥梁资料卡启用或弃用信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("修改桥梁资料卡启用或弃用信息失败");
        }
        return RespBean.success("成功");
    }

    /**
     * 修改桥梁资料卡
     * @param bridgeInfo
     * @param principal
     * @return
     */
    @Override
    public RespBean updateBridgeInfo(BridgeInfo bridgeInfo, Principal principal) {
        if (principal == null) {
            return RespBean.error("修改资料卡失败，权限不足");
        }
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", principal.getName()));
            if (user == null ||user.getType() >= 2) {
                return RespBean.error("修改资料卡失败，权限不足");
            }
            if (bridgeInfoMapper.update(bridgeInfo, new UpdateWrapper<BridgeInfo>().eq("bridge_id", bridgeInfo.getBridgeId())) <= 0) {
                return RespBean.error("修改资料卡失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("修改资料卡失败");
        }
        return RespBean.success("修改桥梁资料卡成功");
    }
}
