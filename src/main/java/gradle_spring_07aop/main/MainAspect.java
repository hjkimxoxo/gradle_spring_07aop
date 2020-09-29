package gradle_spring_07aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gradle_spring_07aop.aop.Calculator;
import gradle_spring_07aop.config.AppCtx;



public class MainAspect {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);){
				Calculator cal = ctx.getBean("calculator", Calculator.class);
				
				long fiveFact = cal.factorial(5);
				System.out.printf("cal.factorial(5) = %d%n", fiveFact);
				System.out.println(cal.getClass().getName());
		}
	}
}
