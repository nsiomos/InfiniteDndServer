package com.nicolesiomos.infinitedndserver.logging;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    
    @Around("execution(public * com.nicolesiomos.infinitedndserver.api.*.*(..)) && @within(org.springframework.web.bind.annotation.RestController)")
    public Object logRestInterface(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String parameters = ToStringBuilder.reflectionToString(methodSignature.getMethod().getParameters());
        
        final StopWatch stopWatch = new StopWatch();
          
        //Measure method execution time
        try {
            stopWatch.start();
            LOGGER.info(String.format(">%s(%s)", methodName, parameters));
            Object result = proceedingJoinPoint.proceed();
            stopWatch.stop();
            LOGGER.info(String.format("<%s:%sms: %s", methodName, stopWatch.getTotalTimeMillis(), ToStringBuilder.reflectionToString(result)));
  
            return result;
        } catch (Exception ex) {
            LOGGER.error(String.format("!%s: %s", methodName, ex));
            throw ex;
        }
    }    
}
