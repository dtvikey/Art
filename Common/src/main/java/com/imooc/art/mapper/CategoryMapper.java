package com.imooc.art.mapper;

import com.imooc.art.entity.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 26/11/18 下午 05:14
 * @Version 1.0
 * 分类
 */
public interface CategoryMapper {
    /**
     * 查询全部油画分类
     * @return  全部蛋糕分类
     */
    @Select("")
    List<Category> getCategories();

}
