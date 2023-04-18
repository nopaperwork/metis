package com.metis.nopaper.work.master.dto;

import java.util.List;
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
public class ProductSpecificationDTO extends AbstractAuditDTO{

	private static final long serialVersionUID = 5140407979297225343L;

	private UUID id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
	private String name;

	@NotNull(message = "Description cannot be null")
	@Size(min = 2, max = 500, message = "Code must be between 2 and 500 characters")
	private String description;
	
	@NotNull(message = "Value cannot be null")
	@Size(min = 2, max = 300, message = "Code must be between 2 and 500 characters")
	private String value;
	
	@NotNull(message = "Code cannot be null")
	@Size(min = 2, max = 50, message = "Code must be between 2 and 50 characters")
	private String code;
	
	@NotNull(message = "State Code cannot be null")
	private UUID productId;
	
	private List<String> aliasName;
}
