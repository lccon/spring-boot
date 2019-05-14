package com.lc.Service.Impl;

import com.lc.Service.PropertyDictService;
import com.lc.domain.PropertyDict;
import com.lc.mapper.PropertyDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
@Service("propertyDictService")
public class PropertyDictServiceImpl implements PropertyDictService {

    @Autowired
    private PropertyDictMapper propertyDictMapper;

    @Override
    public PropertyDict getPropertyDictById(Long id) {
        if(id == null) {
            throw new RuntimeException("参数有误");
        }
        try {
            return propertyDictMapper.getPropertyDictById(id);
        } catch (Exception e) {
            throw new RuntimeException("查询字典项数据有误", e);
        }
    }

}
