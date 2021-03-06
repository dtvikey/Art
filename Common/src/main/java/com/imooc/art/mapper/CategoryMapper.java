package com.imooc.art.mapper;

import com.imooc.art.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
     * @return  全部油画分类
     */
    @Select("select id,name,createName,createTime,updateTime,description from category")
    List<Category> getCategories();

    /**
     * 删除某个分类
     * @param id 要删除的分类ID
     */
    @Delete("delete from category where id=#{id}")
    void deleteById(Long id);

    /**
     * 添加油画分类
     * @param category 油画分类实体
     */
    @Insert("insert into category(name,createName,createTime,updateTime,description) values(#{name},#{createName},#{createTime},#{updateTime},#{description})")
    void addCategory(Category category);
}
