package com.lc.mapper;

import com.lc.domain.PropertyDict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
@Mapper
@Repository
public interface PropertyDictMapper {

    PropertyDict getPropertyDictById(Long id);

}
