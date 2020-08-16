package com.transaction.dao;

public interface AccountDao {
    void addMoney(String userName, int account);

    void reduceMoney(String userName, int account);
}
