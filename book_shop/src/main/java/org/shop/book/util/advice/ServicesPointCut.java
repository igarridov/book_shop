package org.shop.book.util.advice;

import org.aspectj.lang.annotation.Pointcut;

public class ServicesPointCut {

	@Pointcut("execution(* org.shop.book.service..impl.*.*(..))")
	public void allBusinessServices() {
		// PointCut - Todos los servicios de negocio
	}

}
