package com.metis.nopaper.work.master.dto;

import java.util.List;
import java.util.UUID;

import com.metis.nopaper.work.master.enums.EUnitStandard;
import com.metis.nopaper.work.master.models.auditing.AbstractAuditDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UnitDTO extends AbstractAuditDTO{

	private static final long serialVersionUID = -5967502173699235717L;

	private UUID id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
	private String name;

	@NotNull(message = "Description cannot be null")
	@Size(min = 3, max = 5000, message = "Description must be between 3 and 5000 characters")
	private String description;

	@NotNull(message = "Code cannot be null")
	@Size(min = 2, max = 50, message = "Code must be between 2 and 50 characters")
	private String code;
	
	@NotNull(message = "Standard cannot be null")
	private EUnitStandard standard;
	
	private List<String> aliasName;
}
