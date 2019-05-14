package com.lc.Service.Impl;

import com.lc.Service.PropertyDictService;
import com.lc.Service.TaskPloyService;
import com.lc.domain.PropertyDict;
import com.lc.domain.TaskPloy;
import com.lc.mapper.TaskPloyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
@Service("taskPloyService")
public class TaskPloyServiceImpl implements TaskPloyService {

    @Autowired
    private TaskPloyMapper taskPloyMapper;
    @Autowired
    private PropertyDictService propertyDictService;

    @Override
    public TaskPloy getTaskPloyById(Long id) {
        if(id == null) {
            throw new RuntimeException("参数有误");
        }
        try {
            TaskPloy taskPloy = taskPloyMapper.getTaskPloyById(id);
            PropertyDict propertyDict = propertyDictService.getPropertyDictById(taskPloy.getPropertyDict().getId());
            taskPloy.setPropertyDict(propertyDict);
            return taskPloy;
        } catch (Exception e) {
            throw new RuntimeException("查询任务策略失败", e);
        }
    }
}
