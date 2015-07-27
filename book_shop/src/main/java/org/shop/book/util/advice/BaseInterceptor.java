package org.shop.book.util.advice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StringUtils;

public class BaseInterceptor {

	private static final Logger LOG = LogManager
			.getLogger(BaseInterceptor.class);

	protected String getUser() {
		String user = "system";

		/*
		 * if (SecurityContextHolder.getContext().getAuthentication() != null) {
		 * // Recuperar el usuario para dejar rastro user =
		 * SecurityContextHolder.getContext().getAuthentication().getName(); }
		 */

		return user;
	}

	protected String getMethodSignature(ProceedingJoinPoint pjp) {
		String targetName = pjp.getTarget().getClass().getSimpleName();
		String methodName = pjp.getSignature().getName();

		return targetName + "." + methodName;
	}

	protected final String getMethodArgs(ProceedingJoinPoint pjp) {
		String args = "";

		try {
			args = StringUtils.arrayToCommaDelimitedString(pjp.getArgs());
		} catch (Exception ex) {
			LOG.warn("Error al obtener los argumentos del método.", ex);
		}

		return args;
	}

}
