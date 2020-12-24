package io.gy.plat.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 申请列表信息
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Data
@ToString
public class ApplyRecordEntity implements Serializable {

    private static final long serialVersionUID = 10404765814898355L;
    private Integer applyType;
    private Integer status;
    private Date craeteTime;
    private Date platApproveTime;
    private String applyReason;
}

