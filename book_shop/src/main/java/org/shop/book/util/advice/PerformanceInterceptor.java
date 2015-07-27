package org.shop.book.util.advice;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public final class PerformanceInterceptor extends BaseInterceptor {

	private static final Logger LOG = LogManager
			.getLogger(PerformanceInterceptor.class);

	private static final String PETITION_IN = "IN";
	private static final String PETITION_OUT = "OUT";

	private static final char SEPARATOR = '\t';

	@Around("org.shop.book.util.advice.ServicesPointCut.allBusinessServices()")
	public Object doInvokeAnnotatted(ProceedingJoinPoint pjp) throws Throwable {
		String userLogin = getUser();
		String invokedMethod = getMethodSignature(pjp);

		if (LOG.isInfoEnabled()) {
			LOG.info(getPerformanceMessage(userLogin, PETITION_IN,
					invokedMethod, null));
		}

		long start = System.currentTimeMillis();

		try {
			return pjp.proceed();
		} finally {
			if (LOG.isInfoEnabled()) {
				long interval = System.currentTimeMillis() - start;
				LOG.info(getPerformanceMessage(userLogin, PETITION_OUT,
						invokedMethod, interval));
			}
		}
	}

	/**
	 * Genera el mensaje de LOG de rendimiento
	 * 
	 * @param userLogin
	 * @param petitionStatus
	 * @param invokedMethod
	 * @param interval
	 * @return
	 */
	private String getPerformanceMessage(String userLogin,
			String petitionStatus, String invokedMethod, Long interval) {
		StringBuilder sbuffer = new StringBuilder();
		sbuffer.append(SEPARATOR);
		sbuffer.append(StringUtils.isNotEmpty(userLogin) ? userLogin : "system");
		sbuffer.append(SEPARATOR);
		sbuffer.append(petitionStatus);
		sbuffer.append(SEPARATOR);
		sbuffer.append(StringUtils.isNotEmpty(invokedMethod) ? invokedMethod
				: "-");
		sbuffer.append(SEPARATOR);
		sbuffer.append(interval == null ? "-" : interval); // Tiempo
		return sbuffer.toString();
	}
}
