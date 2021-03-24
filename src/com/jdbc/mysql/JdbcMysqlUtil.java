package com.jdbc.mysql;

import java.sql.*;

/**
 * @author
 * @date 2021-03-11-14:30
 */
public class JdbcMysqlUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        //1.加载驱动程序
        Connection conn = null;
        //2. 获得数据库连接
        Statement statement = null;
        //3.操作数据库，实现增删改查
        ResultSet resultSet = null;
        try {
            /**
             * 加载类“com.mysql.jdbc.Driver”。这是弃用。
             * 新的驱动类是' com.mysql.cj.jdbc.Driver'。
             * 驱动程序是通过SPI自动注册的，手动加载驱动程序类通常是不必要的。
             */
//            Class.forName("com.mysql.jdbc.Driver");
            /**
             * DataSource接口是JDBC 2.0 API中的新功能.
             * 应用程序不再需要使用Class.forName()显式加载JDBC驱动程序.
             */
//            Class.forName("com.mysql.cj.jdbc.Driver");//不用手动引入jar包
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = conn.createStatement();
            //如果有数据，rs.next()返回true
            resultSet = statement.executeQuery("SELECT * FROM world.country LIMIT 0, 10;");
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "  ");
                System.out.print(resultSet.getString(2) + "  ");
                System.out.println(resultSet.getString(3));
            }
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
