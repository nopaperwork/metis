package com.metis.nopaper.work.security.controller;

import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metis.nopaper.work.security.annotation.AllowAnonymous;
import com.metis.nopaper.work.security.dto.MemoryStats;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("${v1API}")
@RestController
public class HealthCheck {

	private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheck.class);
	
    @AllowAnonymous
    @GetMapping("healthcheck")
    public String getHealthCheck(){
        return "200 ok";
    }

    @AllowAnonymous
    @GetMapping("memory-status")
    public MemoryStats getMemoryStatistics() {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime().totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime().maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime().freeMemory());
        return stats;
    }
    
    @AllowAnonymous
    @PostMapping("getMultiValueMapHeader")
    public MemoryStats getMultiValueMapHeader(@RequestHeader MultiValueMap<String, String> headers) {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime().totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime().maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime().freeMemory());
        
        headers.forEach((key, value) -> {
			LOGGER.info(String.format(
	          "Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
	    });
        
        LOGGER.info("Header Values: {} ", headers);
        
        return stats;
    }
    @AllowAnonymous
    @PostMapping("getMapHeader")
    public MemoryStats getMapHeader(@RequestHeader Map<String, String> headers) {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime().totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime().maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime().freeMemory());
        
        LOGGER.info("Header Values: {} ", headers);
        
        return stats;
    }
    @AllowAnonymous
    @PostMapping("getHttpHeader")
    public MemoryStats getHttpHeader(@RequestHeader HttpHeaders headers) {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime().totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime().maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime().freeMemory());
        
        LOGGER.info("Header Values: {} ", headers);
        
        return stats;
    }
    @AllowAnonymous
    @PostMapping("getHttpServletRequest")
    public MemoryStats getHttpHeader(HttpServletRequest request) {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime().totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime().maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime().freeMemory());
        
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            LOGGER.info(key + ": " + request.getHeader(key));
        }
        
        return stats;
    }
    
}