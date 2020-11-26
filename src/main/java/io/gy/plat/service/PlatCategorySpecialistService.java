package io.gy.plat.service;

import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatCategorySpecialistEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 领域专家 服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
public interface PlatCategorySpecialistService extends IService<PlatCategorySpecialistEntity> {

    /**
     * 获取领域专家申请列表
     *
     * @return List<ApplyRecordEntity>
     */
    List<ApplyRecordEntity> listRecord();
}
