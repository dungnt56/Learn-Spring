package com.example.demo;

//import com.example.demo.api.AuthResponse;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityTestApplication.class, args);
	}

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("check");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken
						("admin", "admin"));
//		System.out.println("check " + authentication);
//		User user = (User) authentication.getPrincipal();
//		System.out.println(user);
//		String accessToken = jwtTokenUtil.generateAccessToken(user);
////		AuthResponse response = new AuthResponse(user.getUsername(), accessToken);
////		System.out.println(response);
//		System.out.println("JwtTokenUtil Login");
	}
}
