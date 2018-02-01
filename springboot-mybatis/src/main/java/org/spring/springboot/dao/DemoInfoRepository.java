package org.spring.springboot.dao;

import org.spring.springboot.domain.DemoInfo;
import org.springframework.data.repository.CrudRepository;

public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {

}