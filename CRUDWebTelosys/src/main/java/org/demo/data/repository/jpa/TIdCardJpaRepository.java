package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.TIdCardEntity;

/**
 * Repository : TIdCard.
 */
public interface TIdCardJpaRepository extends PagingAndSortingRepository<TIdCardEntity, Long> {

}
