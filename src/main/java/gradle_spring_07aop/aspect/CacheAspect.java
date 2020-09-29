package gradle_spring_07aop.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<>();
	
	@Pointcut("execution(public * gradle_spring_07aop.aop..*(long))")
	public void cacheTarget() {}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
		Long num = (Long) jointPoint.getArgs()[0]; 
		if(cache.containsKey(num)) {
			System.out.printf("cacheAspect:Cache에서 구함[%d]%n", num);
			return cache.get(num);
		}
		Object result = jointPoint.proceed();
		cache.put(num, result);
		System.out.printf("cacheAspect:Cache에 추가[%d]%n", num);
		return result;
	}
	

}
