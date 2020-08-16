package com.jdbcTemplate.dao;

import com.jdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        String insertSql = "insert into book values(?,?,?)";
        Object[] args = {book.getId(), book.getName(), book.getAuthor()};
        int num = jdbcTemplate.update(insertSql, args);
        System.out.println(num);
    }

    @Override
    public void update(Book book) {
        String updateSql = "update book set name =? , author =? where id =?";
        Object[] args = {book.getName(), book.getAuthor(), book.getId()};
        int num = jdbcTemplate.update(updateSql, args);
        System.out.println(num);
    }

    @Override
    public void delete(int id) {
        String deleteSql = "delete from book where id = ? ";
        int num = jdbcTemplate.update(deleteSql, id);
        System.out.println(num);
    }

    @Override
    public int count() {
        String countSql = "select count(*) from book";
        int num = jdbcTemplate.queryForObject(countSql, Integer.TYPE);
        return num;
    }

    @Override
    public Book findById(int id) {
        String findSql = "select * from book where id =? ";
        Book book = jdbcTemplate.queryForObject(findSql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String findAllSql = "select * from book";
        List<Book> books = jdbcTemplate.query(findAllSql, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    @Override
    public void batchInsert(List<Book> books) {
        String batchInsert = "insert into book values(?, ?, ?)";
        List<Object[]> list = books.stream().map(book -> new Object[]{book.getId(), book.getName(), book.getAuthor()}).collect(Collectors.toList());
        jdbcTemplate.batchUpdate(batchInsert, list);
    }

    @Override
    public void batchUpdate(List<Book> books) {
        String batchUpdate = "update book set name = ?, author = ? where id = ?";
        List<Object[]> list = books.stream().map(book -> new Object[]{book.getName(), book.getAuthor(), book.getId()}).collect(Collectors.toList());
        jdbcTemplate.batchUpdate(batchUpdate, list);
    }

    @Override
    public void batchDelete(List<Integer> bookIds) {
        String batchDelete = "delete from book where id = ?";
        List<Object[]> list = bookIds.stream().map(id -> new Object[]{id}).collect(Collectors.toList());
        jdbcTemplate.batchUpdate(batchDelete, list);
    }

}
