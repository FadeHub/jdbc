package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: Book
 * @ProjectName jdbc
 * @Description: TODO
 * @date 2020/6/7 17:44
 */
public class Book {

    private int id;

    private String author;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
