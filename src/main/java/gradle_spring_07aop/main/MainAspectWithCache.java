package gradle_spring_07aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gradle_spring_07aop.aop.Calculator;
import gradle_spring_07aop.config.AppCtx;

public class MainAspectWithCache {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class)){
			Calculator cal = ctx.getBean("calculator", Calculator.class);
			cal.factorial(7);
			cal.factorial(7);
			cal.factorial(5);
			cal.factorial(5);
			ctx.close();
		}

	}

}
