package in.ankit.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ankit.bindings.LoginUser;
import in.ankit.bindings.RegisterUser;
import in.ankit.models.UserEntity;
import in.ankit.repos.UserRepository;
import in.ankit.security.JwtService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtService jwtService;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Override
	public String register(RegisterUser user) {
		
		Optional<UserEntity> byEmail = userRepo.findByEmail(user.getEmail());
		if(byEmail.isPresent()) {
			return "User Already Exists!!";
		}
		
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
		if(user.getRole() == null || user.getRole().isEmpty()) {
			user.setRole(user.getRole());
		}
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userRepo.save(userEntity);
		return "User Register Successfully";
	}

	
	@Override
	public String login(LoginUser user) {
		
		Optional<UserEntity> byEmail = userRepo.findByEmail(user.getEmail());
		if(!byEmail.isPresent()) {
			return "Please Sign In";
		}
		
		UserEntity userEntity = byEmail.get();
		boolean passwordMatches = passwordEncoder.matches(user.getPassword(), userEntity.getPassword());
		if(!passwordMatches){
			return "Password doesn't match!!";
		}
		String token = jwtService.generateToken(user.getEmail());
		return token;
	}

}
