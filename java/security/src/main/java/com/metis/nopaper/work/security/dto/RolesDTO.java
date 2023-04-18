package com.metis.nopaper.work.security.dto;

import com.metis.nopaper.work.security.enums.ERole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RolesDTO {
	private ERole name;
	private String description;
}
