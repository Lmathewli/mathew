package com.mathew.preference.helper;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class PreferenceHelper {

    public PreferenceHelper() {
        
    }
    @Pointcut("execution(com.mathew.controller.*Controller.*())")
    public void sleeppoint(){}

    @Before("sleeppoint()")
    public void beforeSleep(){
        System.out.println("睡觉前要脱衣服!");
    }

    @AfterReturning("sleeppoint()")
    public void afterSleep(){
        System.out.println("睡醒了要穿衣服！");
    }

}
