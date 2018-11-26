package com.imooc.art.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: dtvikey
 * @Date: 26/11/18 下午 04:25
 * @Version 1.0
 * MyBatis工具类
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    // static{}(即static块)
    // 会在类被加载的时候执行且仅会被执行一次
    // 一般用来初始化静态变量和调用静态方法
    static {
        try {
            String resource = "config.xml";
            //获取resources目录下的config.xml的配置文件
            reader = Resources.getResourceAsReader(resource);
            //创建SqlSessionFactory工程对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回SqlSession对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

}
