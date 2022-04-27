package com.example.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
//          读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//            从流中加载数据
            properties.load(inputStream);
            //        创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取数据库连接池的连接   如果返回null说明连接失败<br/>有值就是获取连接成功
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    public static void releaseResoure(Statement statement, Connection connection){
        //1、Statement对象用于执行不带参数的简单SQL语句。2、Prepared Statement 对象用于执行预编译SQL语句。3、Callable Statement对象用于执行对存储过程的调用。
        //关闭数据库
        //statement对象用于执行静态的SQL语句，并且返回执行结果
        try {
            if(statement != null)
                //先关闭statement在关connection
                statement.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e3) {
            e3.printStackTrace();
        }

    }

    public static void releaseResoure(ResultSet rs, Statement statement, Connection connection){
        //1、Statement对象用于执行不带参数的简单SQL语句。2、Prepared Statement 对象用于执行预编译SQL语句。3、Callable Statement对象用于执行对存储过程的调用。
        //关闭数据库
        //statement对象用于执行静态的SQL语句，并且返回执行结果
        try {
            if(rs !=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(statement != null)
                //先关闭statement在关connection
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
