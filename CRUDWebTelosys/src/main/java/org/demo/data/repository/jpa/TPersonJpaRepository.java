package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.TPersonEntity;

/**
 * Repository : TPerson.
 */
public interface TPersonJpaRepository extends PagingAndSortingRepository<TPersonEntity, Long> {

}
