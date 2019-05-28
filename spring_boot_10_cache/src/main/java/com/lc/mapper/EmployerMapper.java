package com.lc.mapper;

import com.lc.domain.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
@Mapper
@Repository
public interface EmployerMapper {

    List<Emp> findEmployerForList();

    void addEmp(Emp emp);
}
