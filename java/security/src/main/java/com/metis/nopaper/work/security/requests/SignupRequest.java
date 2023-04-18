package com.metis.nopaper.work.security.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequest {

	@Email
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 4, max = 100)
	private String email;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 8, max = 20)
	@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
	private String mobile;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 6, max = 20)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])(?=\\S+$).{8,20}$")
	private String password;
	
	@Size(min = 0, max = 512)
	private String deviceCode = "-";
	
	@Size(min = 0, max = 512)
	private String timeZone = "-";
	
}
