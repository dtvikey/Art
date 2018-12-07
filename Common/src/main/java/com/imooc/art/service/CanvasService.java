package com.imooc.art.service;

import com.imooc.art.common.MyBatisUtils;
import com.imooc.art.entity.Canvas;
import com.imooc.art.mapper.CanvasMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 29/11/18 上午 09:58
 * @Version 1.0
 * 油画
 */
public class CanvasService {

    /**
     * 根据分类分页查询油画
     * @param categoryId 油画分类ID
     * @param page  要查询的页数
     * @param size  要查询的记录数
     * @return  油画集合
     */
    public List<Canvas> getCanvasByCategoryId(Long categoryId,Integer page,Integer size){

        SqlSession sqlSession = MyBatisUtils.openSession();
        try {

            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvasByCategoryId(categoryId, (page - 1) * size, size);

        } finally {

             sqlSession.close();

        }

    }

    /**
     * 新增油画
     * @param canvas 油画信息
     */
    public void addCanvas(Canvas canvas){

        Date now = new Date();
        canvas.setCreateTime(now);
        canvas.setUpdateTime(now);

        SqlSession sqlSession = MyBatisUtils.openSession();
        try {

            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.addCanvas(canvas);
            sqlSession.commit();

        } finally {

            sqlSession.close();

        }

    }

    /**
     * 统计给定分类ID下的蛋糕数量
     * @param categoryId  分类ID
     * @return 统计结果
     */
    public int countCanvasByCategoryId(Long categoryId){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try{
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.countCanvasByCategoryId(categoryId);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据ID查询对应的图片
     * @param id 蛋糕ID
     * @return 只包含图片信息的蛋糕实体
     */
    public Canvas getCanvasImg(Long id){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try{
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getImg(id);
        }finally {
            sqlSession.close();
        }
    }

}
