package com.li.vhr.mapper;

import com.li.vhr.model.JObLevel;

public interface JObLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JObLevel record);

    int insertSelective(JObLevel record);

    JObLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JObLevel record);

    int updateByPrimaryKey(JObLevel record);
}