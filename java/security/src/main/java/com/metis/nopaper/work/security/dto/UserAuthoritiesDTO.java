package com.metis.nopaper.work.security.dto;

import com.metis.nopaper.work.security.enums.EAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserAuthoritiesDTO {
	private EAuthority name;
	private String description;
}
