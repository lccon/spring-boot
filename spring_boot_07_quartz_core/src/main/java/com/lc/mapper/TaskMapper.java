package com.lc.mapper;

import com.lc.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
@Mapper
@Repository
public interface TaskMapper {

    List<Task> findTaskForList();

}
