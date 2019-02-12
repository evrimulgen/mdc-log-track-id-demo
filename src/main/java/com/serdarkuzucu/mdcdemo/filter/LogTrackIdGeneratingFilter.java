package com.serdarkuzucu.mdcdemo.filter;

import com.serdarkuzucu.mdcdemo.util.LogTrackIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Serdar Kuzucu
 */
@Component
public class LogTrackIdGeneratingFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(LogTrackIdGeneratingFilter.class);
    private static final String LOG_TRACK_ID_MDC_KEY = "logTrackId";

    private final LogTrackIdGenerator logTrackIdGenerator;

    @Autowired
    public LogTrackIdGeneratingFilter(LogTrackIdGenerator logTrackIdGenerator) {
        this.logTrackIdGenerator = logTrackIdGenerator;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String logTrackId = logTrackIdGenerator.generate();
        MDC.put(LOG_TRACK_ID_MDC_KEY, logTrackId);

        LOG.debug("Log track id {} generated", logTrackId);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(LOG_TRACK_ID_MDC_KEY);
        }
    }
}