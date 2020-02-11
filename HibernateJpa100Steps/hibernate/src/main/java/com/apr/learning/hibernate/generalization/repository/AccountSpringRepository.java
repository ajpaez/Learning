package com.apr.learning.hibernate.generalization.repository;

import com.apr.learning.hibernate.generalization.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSpringRepository extends JpaRepository<Account, Long> {

}
