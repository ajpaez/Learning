package com.apr.learning.hibernate.generalization;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.generalization.entity.CreditAccount;
import com.apr.learning.hibernate.generalization.entity.DebitAccount;
import com.apr.learning.hibernate.generalization.repository.AccountSpringRepository;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class AccountSpringRepositoryTest {

    @Autowired
    AccountSpringRepository accountRepository;

    @Test
    @Transactional
    void saveDebitAccountTest() {
        DebitAccount debitAccount = new DebitAccount("John", 1500L, 5L, 1L);
        DebitAccount debitAccount1 = accountRepository.save(debitAccount);
        Assert.assertNotNull(debitAccount1.getId());
    }

    @Test
    @Transactional
    void saveCreditAccountTest() {
        CreditAccount creditAccount = new CreditAccount("John", 1500L, 5L, 100L);
        CreditAccount creditAccount1 = accountRepository.save(creditAccount);
        Assert.assertNotNull(creditAccount1.getId());
    }


}
