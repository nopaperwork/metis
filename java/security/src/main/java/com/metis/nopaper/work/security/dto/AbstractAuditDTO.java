package com.metis.nopaper.work.security.dto;

import java.time.Instant;

import com.metis.nopaper.work.security.constant.SecurityConstant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AbstractAuditDTO {

	private String createdBy = SecurityConstant.DEFAULT_ACTOR;
	private Instant createdDate = Instant.now();
	private String lastModifiedBy = SecurityConstant.DEFAULT_ACTOR;
	private String status = SecurityConstant.DEFAULT_STATUS;
	private Instant lastModifiedDate = Instant.now();
	
}
