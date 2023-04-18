package com.metis.nopaper.work.master.models.auditing;

import java.io.Serializable;
import java.time.Instant;

import com.metis.nopaper.work.master.constant.MasterConstant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AbstractAuditDTO implements Serializable {

	private static final long serialVersionUID = 534578740658054243L;
	private String createdBy = MasterConstant.DEFAULT_ACTOR;
	private Instant createdDate = Instant.now();
	private String lastModifiedBy = MasterConstant.DEFAULT_ACTOR;
	private String status = MasterConstant.DEFAULT_STATUS;
	private Instant lastModifiedDate = Instant.now();
	
}
