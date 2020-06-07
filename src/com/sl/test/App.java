package com.sl.test;

import com.sl.entity.Book;
import com.sl.util.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: App
 * @ProjectName jdbc
 * @Description: TODO
 * @date 2020/6/7 17:08
 */
public class App {

    public static void main(String[] args) throws Exception {
      //testStatement();
       // testPreStatement();
        testSelect();
    }

    public static void testStatement() throws Exception{
        Connection connection = JdbcConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into book(author,name) values ('三毛','撒哈拉沙漠')";
        statement.execute(sql);
        JdbcConnectionUtil.close(connection);
        JdbcConnectionUtil.close(statement);
    }

    public static void testPreStatement() throws Exception{
        Connection connection = JdbcConnectionUtil.getConnection();
        String sql = "insert into book(author,name) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"李四");
        preparedStatement.setString(2,"围城");
        preparedStatement.executeUpdate();
        //preparedStatement.addBatch();
        JdbcConnectionUtil.close(connection);
        JdbcConnectionUtil.close(preparedStatement);
    }

    public static void testSelect() throws Exception{
        Connection connection = JdbcConnectionUtil.getConnection();
        String sql = "select * from book";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");
            Book book = new Book();
            book.setId(id);
            book.setAuthor(author);
            book.setName(name);
            books.add(book);
        }
        System.out.println(books.size());
        JdbcConnectionUtil.close(connection);
        JdbcConnectionUtil.close(preparedStatement);
    }

}
