package com.example.dds.aop;

import com.example.dds.config.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
@Aspect
@Component
public class DataSourceAop {
    //在primary方法前执行
    @Before("execution(* com.example.dds.controller.Controller.test1(..))")
    public void setDataSource2test01() {
        log.info("Master DataSource");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.MASTER);
    }

    //在secondary方法前执行
    @Before("execution(* com.example.dds.controller.Controller.test2(..))")
    public void setDataSource2test02() {
        log.info("Slave DataSource");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.SLAVE);
    }


}
