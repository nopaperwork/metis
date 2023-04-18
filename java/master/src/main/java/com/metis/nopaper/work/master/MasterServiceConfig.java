package com.metis.nopaper.work.master;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "master")
@Data
public class MasterServiceConfig {

	private String msg;
	private String buildVersion;
	private String v1API;
	private Map<String, String> server;
}
