package com.lc.mapper;

import com.lc.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @Date:2019/5/7
 * @Author:lc
 */
@Mapper
public interface UserMapper {

    public void addUser(User user);

}
