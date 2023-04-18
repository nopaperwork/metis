package com.metis.nopaper.work.master.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.metis.nopaper.work.master.enums.EOrganizationType;
import com.metis.nopaper.work.master.models.auditing.AbstractAuditDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizationTypeDTO extends AbstractAuditDTO{

	private static final long serialVersionUID = -5356128569617098672L;

	private UUID id;
	
	@NotNull(message = "Name cannot be null")
	private EOrganizationType name;

	@NotNull(message = "Description cannot be null")
	private String description;
	
	@NotNull(message = "Code cannot be null")
	@Size(min = 2, max = 50, message = "Code must be between 2 and 50 characters")
	private String code;

	private List<String> aliasName;
}
