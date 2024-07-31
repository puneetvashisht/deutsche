
// package declaration

package com.dte.spring_boot_jpa_demo2.services;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import slf4j;


@Service
// @Slf4j
public class CourseService implements ICourseService{

    Logger log = LoggerFactory.getLogger(CourseService.class);
    public void someLogic(){
        // System.out.println("CourseService logic here... 12345678901234");
        log.debug("CourseService logic here... 12345678901234");
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
    } 
}
