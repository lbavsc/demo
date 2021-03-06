package io.gy.plat.controller;

import io.gy.plat.entity.ApplyRecordEntity;
import io.gy.plat.entity.ResultEntity;
import io.gy.plat.service.PlatCategorySpecialistService;
import io.gy.plat.service.PlatSupplierService;
import io.gy.plat.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 获取申请记录
 *
 * @author ${author}
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/apply")
public class ApplyRecordController {

    @Resource
    private PlatCategorySpecialistService platCategorySpecialistService;
    @Resource
    private PlatSupplierService platSupplierService;

    @GetMapping("/all")
    public ResultEntity recordAll() {

        try {
            List<ApplyRecordEntity> result = new ArrayList<>();
            result.addAll(platCategorySpecialistService.listRecord());
            result.addAll(platSupplierService.listRecord());
            result.sort(Comparator.nullsFirst(Comparator.comparing(ApplyRecordEntity::getCraeteTime).reversed()));
            return ResultUtil.success(result);

        } catch (Exception e) {
            return ResultUtil.error("1001", "系统发生错误,请联系管理员");
        }

    }


}
