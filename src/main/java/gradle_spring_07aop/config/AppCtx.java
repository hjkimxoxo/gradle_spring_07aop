package gradle_spring_07aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import gradle_spring_07aop.aop.Calculator;
import gradle_spring_07aop.aop.RecCalculator;
import gradle_spring_07aop.aspect.CacheAspect;
import gradle_spring_07aop.aspect.ExeTimeAspect;



@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean 
	public Calculator calculator() {
		return new RecCalculator();
	}
	
	

}
