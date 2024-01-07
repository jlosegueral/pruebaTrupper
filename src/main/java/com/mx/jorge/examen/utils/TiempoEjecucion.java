package com.mx.jorge.examen.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TiempoEjecucion {
	
public static final Logger logger = LoggerFactory.getLogger(TiempoEjecucion.class);
	
	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object medirTiempoEjecucion(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long tiempoDeEjecucion = endTime - startTime;

        // Obtén información sobre el método y la clase
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        // Log del tiempo de ejecución
        logger.info(String.format("Método %s en la clase %s ejecutado en %d ms", methodName, className, tiempoDeEjecucion));
        
        return result;
    }

}
