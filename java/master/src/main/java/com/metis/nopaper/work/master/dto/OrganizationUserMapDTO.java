package com.metis.nopaper.work.master.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizationUserMapDTO {
	private UUID id;
	private UUID organizationId;
	private UUID organizationBranchId;
	private UUID userId;
}
