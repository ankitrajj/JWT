package in.ankit.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ankit.bindings.LoginUser;
import in.ankit.bindings.RegisterUser;
import in.ankit.services.UserService;


@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegister(@RequestBody RegisterUser user) {
		String msg = userService.register(user);
		return ResponseEntity.ok().body(msg);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> userLogin(@RequestBody LoginUser user) {
		String msg = userService.login(user);
		return ResponseEntity.ok(Map.of("token", msg));
		
	}
	
	@GetMapping("/profile")
    public String profile() {
        return "Access granted! This is a protected route.";
    }
	
}
