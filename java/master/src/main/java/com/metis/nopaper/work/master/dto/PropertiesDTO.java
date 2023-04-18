package com.metis.nopaper.work.master.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesDTO {
	
	private String msg;
	private String buildVersion;
	private String v1API;
	private Map<String, String> server;

}
