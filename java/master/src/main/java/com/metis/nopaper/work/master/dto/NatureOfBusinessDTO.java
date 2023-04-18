package com.metis.nopaper.work.master.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.metis.nopaper.work.master.enums.ENatureOfBusiness;
import com.metis.nopaper.work.master.models.auditing.AbstractAuditDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NatureOfBusinessDTO extends AbstractAuditDTO{

	private static final long serialVersionUID = -5602136021348673196L;

	private UUID id;
	
	@NotNull(message = "Name cannot be null")
	private ENatureOfBusiness name;

	@NotNull(message = "Description cannot be null")
	@Size(min = 3, max = 200, message = "Description must be between 3 and 200 characters")
	private String description;

	@NotNull(message = "Code cannot be null")
	@Size(min = 2, max = 50, message = "Code must be between 2 and 50 characters")
	private String code;
	
	private List<String> aliasName;
}
