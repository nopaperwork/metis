package com.metis.nopaper.work.master.dto;

import java.util.UUID;

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
public class CityDTO extends AbstractAuditDTO{

	private static final long serialVersionUID = 5727012491590626598L;

	private UUID id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
	private String name;

	@NotNull(message = "Code cannot be null")
	@Size(min = 2, max = 50, message = "Code must be between 2 and 50 characters")
	private String code;
	
	@Size(min = 2, max = 4, message = "Telephone Code must have atlease two character")
	private String telephoneCode;
	
	private Integer pin;
	
	@NotNull(message = "State Code cannot be null")
	private UUID stateId;
}
