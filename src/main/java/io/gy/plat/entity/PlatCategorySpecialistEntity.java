package io.gy.plat.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 领域专家
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("plat_category_specialist")
@ApiModel(value = "PlatCategorySpecialist对象", description = "领域专家")
public class PlatCategorySpecialistEntity implements Serializable {

    private static final long serialVersionUID = 1883820189478836023L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "领域id")
    private Integer categoryId;

    @ApiModelProperty(value = "人员id")
    private Integer userId;

    @ApiModelProperty(value = "状态	0 可用状态	1 企业管理员待审批状态	2 领域专家待审批状态	3 平台管理员待审批状态	4 驳回")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date craeteTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date platApproveTime;

    @ApiModelProperty(value = "证书地址")
    private String fileUrl;
}
