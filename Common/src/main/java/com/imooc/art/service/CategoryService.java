package com.imooc.art.service;

import com.imooc.art.common.MyBatisUtils;
import com.imooc.art.entity.Category;
import com.imooc.art.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 29/11/18 上午 10:10
 * @Version 1.0
 * 分类
 */
public class CategoryService {

    /**
     * 查询全部油画分类
     * @return  全部油画分类
     */
    public List<Category> getCategories(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try{
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategories();
        }finally {
            sqlSession.close();
        }
    }
}
