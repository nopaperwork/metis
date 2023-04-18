package com.metis.nopaper.work.security.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 6, max = 100, message="Identity should have be more than 6 characters")
	private String identity;

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 6, max = 20, message="Password should have be more than 8 characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])(?=\\S+$).{8,20}$")
//	ACTUAL = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,20}$"
	private String password;

	private String deviceCode = "-";
	private String timeZone = "-";

}
