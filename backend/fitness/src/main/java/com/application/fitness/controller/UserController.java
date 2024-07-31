package com.application.fitness.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fitness.entities.ERole;
import com.application.fitness.entities.Role;
import com.application.fitness.entities.User;
import com.application.fitness.repos.RoleRepo;
import com.application.fitness.repos.UserRepo;
import com.application.fitness.request.LoginRequest;
import com.application.fitness.request.SignUpRequest;
import com.application.fitness.response.JwtResponse;
import com.application.fitness.response.MessageResponse;
import com.application.fitness.security.jwt.JwtUtils;
import com.application.fitness.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	RoleRepo roleRepository;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		System.out.println("In sign in method...." + loginRequest);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		
		System.out.println("test 1....");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.println("test 2....");
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		System.out.println("test 3....");

		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		System.out.println("In register user...");
		if (userRepo.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
//		if(signUpRequest.getRole() == "user") {
//		User user = new User(signUpRequest.getEmail(),signUpRequest.getPassword());
//		
//		System.out.println(user);
//		userRepo.save(user);
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//		}else {
			User user = new User(signUpRequest.getEmail(),
													 encoder.encode(signUpRequest.getPassword())
//													 false
//													 ,"https://storage.googleapis.com/download/storage/v1/b/domshom-web-273102.appspot.com/o/1598694009755_file?generation=1598694010746065&alt=media"
					);
			
			System.out.println("testing......");
			Set<String> strRoles = signUpRequest.getRole();
			System.out.println("testing1......");

			Set<Role> roles = new HashSet<>();
			System.out.println("testing2......");

			if (strRoles == null) {
				System.out.println("testing3......" + ERole.ROLE_USER);

				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				System.out.println("testing4......"+ userRole);

				roles.add(userRole);
			} else {
				System.out.println("testing5......");

				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					case "mod":
						Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(modRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}

			user.setRoles(roles);

			System.out.println(user);
			userRepo.save(user);
			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//		}
	}
}


//