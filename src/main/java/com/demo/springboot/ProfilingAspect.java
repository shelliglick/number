package com.demo.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ProfilingAspect {
	
	@Around("execution(* com.demo..*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		Signature method = pjp.getSignature();
		try {
			return pjp.proceed();
		} finally {
			System.out.println(method  + " took " + (System.nanoTime() - start) + " nanos");
		}
	}

}
