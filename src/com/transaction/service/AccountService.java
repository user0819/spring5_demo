package com.transaction.service;

import com.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false, noRollbackFor = ArithmeticException.class)
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void transfer(){
        accountDao.addMoney("wang", 100);
        //int a = 10/0;
        accountDao.reduceMoney("xiang", 100);
        System.out.println("转账完毕");
    }
}
