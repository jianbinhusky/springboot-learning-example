package org.spring.springboot.service;

import javassist.NotFoundException;
import org.spring.springboot.domain.DemoInfo;

public interface DemoInfoService {

    void delete(Long id);

    DemoInfo update(DemoInfo updated) throws NotFoundException;

    DemoInfo findById(Long id);

    DemoInfo save(DemoInfo demoInfo);

}
