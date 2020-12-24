package io.gy.plat.dao;

import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatCategorySpecialistEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 * 领域专家 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Mapper
public interface PlatCategorySpecialistDao extends BaseMapper<PlatCategorySpecialistEntity> {
    /**
     * 获取领域专家申请列表
     *
     * @return List<ApplyRecordEntity>
     */
    List<ApplyRecordEntity> getPlatCategorySpecialistRecord();
}
