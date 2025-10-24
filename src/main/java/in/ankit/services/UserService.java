package in.ankit.services;

import in.ankit.bindings.LoginUser;
import in.ankit.bindings.RegisterUser;

public interface UserService {

	public String register(RegisterUser user);
	public String login(LoginUser user);
}
