package com.wkl.girl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectGirl {

    private final static Logger logger = LoggerFactory.getLogger(AspectGirl.class);

    @Before("execution( public * com.wkl.girl.GirlController.*(..))")
    public void logBeforeSomething () {
        System.out.println("... Aspect logBeforeSomething ...");
    }

    @Pointcut("execution( public * com.wkl.girl.GirlController.*(..))")
    public void log () {
    }

    @Before("log()")
    public void logBefore (JoinPoint joinpoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpRequest = attributes.getRequest();
        logger.info("... Aspect logBefore getRequestURL:" + httpRequest.getRequestURL());
        logger.info("... Aspect logBefore getMethod:" + httpRequest.getMethod());
        logger.info("... Aspect logBefore getRemoteAddr:" + httpRequest.getRemoteAddr());
        logger.info("... Aspect logBefore getDeclaringTypeName:" + joinpoint.getSignature().getDeclaringTypeName() + " "+joinpoint.getSignature().getName());
        logger.info("... Aspect logBefore getArgs:" + joinpoint.getArgs()[0].toString());
    }

    @After("log()")
    public void logAfter () {
        logger.info("... Aspect logAfter ...");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void logAfterReturning (Object object) {
        logger.info("... Aspect logAfterReturning result: " + object);
    }
}
