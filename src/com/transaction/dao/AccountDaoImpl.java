package com.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney(String userName, int account) {
        String add = "update user_account set account = account + ? where user_name = ?";
        jdbcTemplate.update(add, account, userName);
    }

    @Override
    public void reduceMoney(String userName, int account) {
        String reduce = "update user_account set account = account - ? where user_name = ?";
        jdbcTemplate.update(reduce, account, userName);
    }
}
