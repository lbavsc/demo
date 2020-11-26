package io.gy.plat.service;

import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatSupplierEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
public interface PlatSupplierService extends IService<PlatSupplierEntity> {
    /**
     * 获取供应商申请列表
     *
     * @return List<ApplyRecordEntity>
     */
    List<ApplyRecordEntity> listRecord();
}
