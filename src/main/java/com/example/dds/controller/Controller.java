package com.example.dds.controller;

import com.example.dds.entity.Goods;
import com.example.dds.mapper.GoodsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Controller {

    @Resource
    GoodsMapper goodsMapper;

    @GetMapping("/1")
    public List<Goods> test1(){
        return goodsMapper.selectAll();
    }

    @GetMapping("/2")
    public List<Goods> test2(){
        return goodsMapper.selectAll();
    }

}
