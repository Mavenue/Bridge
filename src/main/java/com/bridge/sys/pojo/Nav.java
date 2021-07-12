package com.bridge.sys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Nav对象", description="")
public class Nav implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "nav_id", type = IdType.AUTO)
    private Integer navId;

    private Integer auth;

    private String name;

    private String component;

    private String icon;

    private String path;

    private String title;

    private String parent;
}
