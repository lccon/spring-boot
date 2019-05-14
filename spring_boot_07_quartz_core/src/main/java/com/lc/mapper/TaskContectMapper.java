package com.lc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Mapper
@Repository
public interface TaskContectMapper {

    void addTaskContect(@Param("name") String name, @Param("group") String group);

}
