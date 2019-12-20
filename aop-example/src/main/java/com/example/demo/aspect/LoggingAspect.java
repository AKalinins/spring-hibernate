package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalTime;

@Aspect
@Component
public class LoggingAspect {
            //This is Pointcut Expression. Only addAccount() of AccountDAO is allowed
    @Before("execution(public void com.example.demo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("LOG ====> Executing @Before addAccount()");
    }

            //This is Pointcut Expression. Only public void addMember(String string) are allowed
    @Before("execution(public void addMember(java.lang.String))")
    public void beforeAddMemberAdvice(JoinPoint joinPoint) { //JoinPoint is used to access method params
        System.out.println("LOG ====> Executing @Before addMember(java.lang.String)");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + signature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Argument " + arg.getClass() + "; Argument value: " + arg);
        }
    }


/*
    Other examples:
    * add*() - method with any return value and access modifier, name starting with add..., no parameters
    * add*(..) - method with any return value and access modifier, name starting with add..., any number of any parameters
    * com.demo.*.*(..) - any method in any class in com.demo package, any return tye and any number of any parameters
 */

    //Declaring reusable Pointcuts
    @Pointcut("execution(* com.example.demo.dao.*.*(..))")
    public void forDaoMethodsAdvice(){}
    @Pointcut("execution(* com.example.demo.dao.*.get*(..))")
    public void getterAdvice() {}
    @Pointcut("execution(* com.example.demo.dao.*.set*(..))")
    public void setterAdvice() {}
    //Using reusable Pointcuts. Getter and Setter methods are excluded
    @After("forDaoMethodsAdvice() && !(getterAdvice() || setterAdvice())")
    public void afterEveryDaoMethod() {
        System.out.println("DAO method executed");
        System.out.println();
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.demo.dao.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowAdviceExample(Throwable exception) {
        System.out.println("LOG ====> Exception was thrown.");
        System.out.println("Message from advice method: " + exception.getMessage());
    }

    @Around("execution(* com.example.demo.domain.Athlete.run(..))")
    public Object aroundAdviceExample(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around advice ==> Executing @Around on method " + proceedingJoinPoint.getSignature().getName());
        StopWatch stopWatch = new StopWatch();
        System.out.println("@Around advice ==> Current time: " + LocalTime.now());
        stopWatch.start();
        System.out.println("@Around advice ==> Proceeding with " + proceedingJoinPoint.getSignature().getName());
        Object result = null;
        try {
           result = proceedingJoinPoint.proceed();
        } catch (RuntimeException rte) {
            System.out.println("@Around advice ==> Exception is thrown: " + rte.getMessage());
            System.out.println("It's ok. No worries.");
            result = "Athlete tripped";
        }
        System.out.println("@Around advice ==> After method " + proceedingJoinPoint.getSignature().getName() + " is run");
        stopWatch.stop();
        System.out.println("@Around advice ==> Current time: " + LocalTime.now());
        System.out.println("@Around advice ==> Task time: " + stopWatch.getTotalTimeSeconds());
        return result;
    }
}

