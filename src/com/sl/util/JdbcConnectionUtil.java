package com.sl.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author shuliangzhao
 * @Title: JdbcConnectionUtil
 * @ProjectName jdbc
 * @Description: TODO
 * @date 2020/6/7 14:08
 */
public class JdbcConnectionUtil {
    //驱动
    private static String DRIVER_NAME = null;
    //链接
    private static String URL = null;
    //用户名
    private static String USER = null;
    //密码
    private static String PASSWORD = null;

    private static Connection conn = null;

    static {
        Properties properties = new Properties();
        InputStream in = JdbcConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(in);
            DRIVER_NAME = properties.getProperty("drivername");
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
        } catch (Exception e) {
           throw new RuntimeException("加载配置文件失败：{}",e);
        }
    }

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("数据库连接异常！",e);
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("数据库关闭异常！",e);
            }
        }

    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException("数据库关闭异常！",e);
            }
        }

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        //PreparedStatement statement = (PreparedStatement) connection.createStatement();
    }
}
