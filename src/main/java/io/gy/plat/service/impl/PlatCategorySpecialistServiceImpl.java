package io.gy.plat.service.impl;


import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatCategorySpecialistEntity;
import io.gy.plat.dao.PlatCategorySpecialistDao;
import io.gy.plat.service.PlatCategorySpecialistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 领域专家 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Service
public class PlatCategorySpecialistServiceImpl extends ServiceImpl<PlatCategorySpecialistDao, PlatCategorySpecialistEntity> implements PlatCategorySpecialistService {
    private static final int APPLY_TYPE_PLAT_CATEGORY_SPECIALIST = 0;

    @Override
    public List<ApplyRecordEntity> listRecord() {
        List<ApplyRecordEntity> applyRecordList = baseMapper.getPlatCategorySpecialistRecord();
        applyRecordList.forEach(p -> {
            p.setApplyType(APPLY_TYPE_PLAT_CATEGORY_SPECIALIST);
            p.setApplyReason("申请理由");
        });
        return applyRecordList;
    }
}
