package com.lc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @Date:2019/5/11
 * @Author:lc
 */
@Mapper
@Repository
public interface EmployerMapper {

    void addEmployer(@Param("name") String name, @Param("age") Integer age);

}
