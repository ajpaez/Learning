package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.TPhoneEntity;

/**
 * Repository : TPhone.
 */
public interface TPhoneJpaRepository extends PagingAndSortingRepository<TPhoneEntity, Long> {

}
