package com.jdbcTemplate.service;

import com.jdbcTemplate.dao.BookDao;
import com.jdbcTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void add(Book book){
        bookDao.add(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void delete(int id){
        bookDao.delete(id);
    }

    public int count(){
       return bookDao.count();
    }

    public Book findById(int id){
        return bookDao.findById(id);
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public void batchInsert(List<Book> books){
        bookDao.batchInsert(books);
    }

    public void batchUpdate(List<Book> books){
        bookDao.batchUpdate(books);
    }

    public void batchDelete(List<Integer> bookIds){
        bookDao.batchDelete(bookIds);
    }

}
