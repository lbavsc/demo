package io.gy.plat.dao;

import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatSupplierEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Repository
public interface PlatSupplierDao extends BaseMapper<PlatSupplierEntity> {
    /**
     * 获取供应商申请列表
     *
     * @return List<ApplyRecordEntity>
     */
    List<ApplyRecordEntity> getPlatSupplierRecord();
}
