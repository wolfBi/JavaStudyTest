package com.bjl.jpa;

import javax.transaction.*;
import java.sql.Connection;

/**
 * java 核心知识点整理.pdf 6.1.11 JPA原理
 */
public class TransactionTest {
    /**
     * 分布式事务
     */
    public static void transferAccount(){
        UserTransaction userTransaction = null;

        Connection connA = null;
        Connection connB = null;

//        userTransaction = (UserTransaction)getContext().lookup("java:comp/UserTransaction");

        try {
            userTransaction.begin();

            // connA connB 做自己的事儿

            userTransaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
            try {
                //事务回滚
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        } finally {

        }

    }
}
