package com.nicolesiomos.infinitedndserver.logging;

import com.google.common.io.Closer;
import com.nicolesiomos.infinitedndserver.logging.util.MdcUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
    
    @Pointcut("execution(public * com.nicolesiomos.infinitedndserver.api.*.*(..))")
    private void isPublicApiMethod() {}
    
    @Pointcut("@target(org.springframework.web.bind.annotation.RestController)")
    private void isRestControllerClass() {}    
    
    @Around("isRestControllerClass() && isPublicApiMethod()")
    public Object logRestInterface(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String parameters = ToStringBuilder.reflectionToString(methodSignature.getMethod().getParameters());
        
        final StopWatch stopWatch = new StopWatch();
        try (Closer context = Closer.create()) {
            stopWatch.start();
            LOGGER.info(String.format(">%s(%s)", methodName, parameters));
            Object result = proceedingJoinPoint.proceed();
            stopWatch.stop();
            MdcUtils.putInCurrentContext(context, MdcKey.DURATION_IN_MS, String.valueOf(stopWatch.getTotalTimeMillis()));
            LOGGER.info(String.format("<%s: %s", methodName, ToStringBuilder.reflectionToString(result)));
  
            return result;
        } catch (Exception ex) {
            LOGGER.error(String.format("!%s: %s", methodName, ex));
            throw ex;
        }
    }    
}
