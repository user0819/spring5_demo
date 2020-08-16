package com.jdbcTemplate.dao;

import com.jdbcTemplate.entity.Book;

import java.util.List;

public interface BookDao {

    void add(Book book);

    void update(Book book);

    void delete(int id);

    int count();

    Book findById(int id);

    List<Book> findAll();

    void batchInsert(List<Book> books);

    void batchUpdate(List<Book> books);

    void batchDelete(List<Integer> bookIds);
}
