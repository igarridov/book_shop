package org.shop.book.util.advice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public final class ErrorInterceptor extends BaseInterceptor {

	private static final char SEPARATOR = '\t';

	private static final Logger LOG = LogManager
			.getLogger(ErrorInterceptor.class);

	@Around("org.shop.book.util.advice.ServicesPointCut.allBusinessServices()")
	public Object doInvokeAnnotatted(ProceedingJoinPoint pjp) throws Throwable {

		try {

			// Proceed with the execution
			return pjp.proceed();

			// FIXME igarridov gestionar excepciones correctamente
		} catch (Exception ex) {
			// Logear el error
			LOG.error(getLogMessage("ERROR_CODE", pjp), ex);
			// Convertir la excepcion
			throw ex;
		}
	}

	private String getLogMessage(String exceptionId, ProceedingJoinPoint pjp) {
		StringBuilder log = new StringBuilder();
		log.append(SEPARATOR);
		log.append(exceptionId);
		log.append(SEPARATOR);
		log.append(getUser());
		log.append(SEPARATOR);
		log.append(getMethodSignature(pjp)).append('(')
				.append(getMethodArgs(pjp)).append(')');
		return log.toString();
	}

}
