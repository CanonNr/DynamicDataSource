package com.example.dds.mapper;

import com.example.dds.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}