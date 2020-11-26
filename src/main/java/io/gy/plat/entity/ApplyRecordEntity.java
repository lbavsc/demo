package io.gy.plat.entity;

import lombok.Data;

import java.util.Date;

/**
 * 申请列表信息
 * @author ${author}
 * @since 2020-11-25
 */
@Data
public class ApplyRecordEntity {
    private Integer applyType;
    private Integer status;
    private Date craeteTime;
    private Date platApproveTime;
    private String applyReason;
}
