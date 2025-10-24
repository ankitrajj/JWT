package in.ankit.bindings;

import lombok.Data;

@Data
public class RegisterUser {	
	private String name;
	private String email;
	private String password;
	private String role;
    
}
