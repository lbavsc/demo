package io.gy.plat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.PlatSupplierEntity;
import io.gy.plat.dao.PlatSupplierDao;
import io.gy.plat.service.PlatSupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-11-25
 */
@Service
public class PlatSupplierServiceImpl extends ServiceImpl<PlatSupplierDao, PlatSupplierEntity> implements PlatSupplierService {
    private final int APPLY_TYPE_PLAT_SUPPLIER = 1;

    @Override
    public List<ApplyRecordEntity> listRecord() {
        List<ApplyRecordEntity> applyRecordList = baseMapper.getPlatSupplierRecord();
        applyRecordList.forEach(p -> p.setApplyType(APPLY_TYPE_PLAT_SUPPLIER));
        return applyRecordList;
    }
}
