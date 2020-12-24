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
 * 供应商表
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("plat_supplier")
@ApiModel(value = "PlatSupplier对象", description = "供应商表")
public class PlatSupplierEntity implements Serializable {

    private static final long serialVersionUID = 1173586248741535281L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "领域id")
    private Integer categoryId;

    @ApiModelProperty(value = "企业id")
    private Integer enterpriseId;

    @ApiModelProperty(value = "状态	0 可用状态	1 企业管理员待审批状态	2 领域专家待审批状态	3 平台管理员待审批状态	4 驳回")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date craeteTime;

    @ApiModelProperty(value = "企业管理员审批时间时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date enterpriseApproveTime;

    @ApiModelProperty(value = "平台审批时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date platApproveTime;

    @ApiModelProperty(value = "申请理由")
    private String applyReason;

}
