package com.imooc.art.mapper;

import com.imooc.art.entity.Canvas;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 26/11/18 下午 05:12
 * @Version 1.0
 * 油画
 */
public interface CanvasMapper {
    /**
     * 分页查询油画
     * @param skip  跳过的记录数, 也就是从哪条开始查询.
     * @param size  要查询的记录数
     * @return  油画
     */
    @Select("select * from canvas order by createTime desc limit #{skip},#{size}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "categoryId",property = "categoryId"),
            @Result(column = "name",property = "name"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "price",property = "price"),
            @Result(column = "createTime",property = "createTime"),
            @Result(column = "updateTime",property = "updateTime"),
            @Result(column = "description",property = "description"),
            @Result(column = "details",property = "details")
    })
    List<Canvas> getCanvas(@Param("skip") Integer skip, @Param("size") Integer size);

    /**
     * 根据分类分页查询油画
     * @param categoryId 油画分类ID
     * @param skip  跳过的记录数, 也就是从哪条开始查询.
     * @param size  要查询的记录数
     * @return  油画集合
     */
    @Select("select id,categoryId,name,creator,price,createTime,updateTime,description,details " +
            "from canvas where categoryId = #{categoryId} order by createTime desc limit #{skip},#{size}")
    List<Canvas> getCanvasByCategoryId(@Param("categoryId") Long categoryId,@Param("skip") Integer skip,@Param("size") Integer size);

    /**
     * 根据分类ID进行统计油画数量
     * @param categoryId 分类ID
     * @return 分类下油画数量
     */
    @Select("select count(*) from canvas where categoryId = #{categoryId}")
    int countCanvasByCategoryId(@Param("categoryId")Long categoryId);

    /**
     * 保存油画信息
     * @param canvas 油画信息
     */
    @Insert("insert into canvas(categoryId,name,creator,price,smallImg,ceateTime,updateTime,description,details) " +
            "value (#{canvas.categoryId}),#{canvas.name},#{canvas.creator},#{canvas.price},#{canvas.smallImg}," +
            "#{canvas.ceateTime},#{canvas.updateTime},#{canvas.description},#{canvas.details})")
    void addCanvas(@Param("canvas") Canvas canvas);

    /**
     * 查询油画图片信息
     * @param id 油画ID
     * @return 只包含图片的油画实体
     */
    @Select("select smallImg from canvas where id =#{id} for update")
    Canvas getImg(@Param("id")Long id);





}
