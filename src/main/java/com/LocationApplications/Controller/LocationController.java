package com.LocationApplications.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LocationApplications.Entity.Role;
import com.LocationApplications.Entity.User;
import com.LocationApplications.Entity.UserRole;
import com.LocationApplications.Models.AuthenticationRequest;
import com.LocationApplications.Models.AuthenticationResponse;
import com.LocationApplications.Repository.RoleRepository;
import com.LocationApplications.Repository.UserRepository;
import com.LocationApplications.Repository.UserRoleRepository;
import com.LocationApplications.Service.MyUserDetailsService;
import com.LocationApplications.Util.JwtUtil;

@RestController
public class LocationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JwtUtil jwtUtil;

//	@PreAuthorize('ADMIN')
	@GetMapping("/users")
	public List<User> getAllUser(Principal principal) {
		return userRepository.findAll();
	}

	@GetMapping("/userRoles")
	public List<UserRole> getAllUserRole(Principal principal) {
		return userRoleRepository.findAll();
	}

	@GetMapping("/roles")
	public List<Role> getAllRoles(Principal principal) {
		return roleRepository.findAll();
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createResponseEntity(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@PostMapping("/users")
	public ResponseEntity<User> saveOrUpdate(@RequestBody User user, Principal principal) {
		User savedUser = userRepository.save(user);

		return ResponseEntity.ok(savedUser);
	}

	@PostMapping("/userRoles")
	public ResponseEntity<UserRole> saveOrUpdate(@RequestBody UserRole userrole, Principal principal) {
		userRoleRepository.save(userrole);
		User user = new User();
		user.setFullName("abdc");
		user.setUserName("A0497382");
		Role role = new Role();
		role.setId(2);
		role.setName("A0497382");
		UserRole userRole2 = new UserRole(user,role);
		userRoleRepository.save(userRole2);
		return ResponseEntity.ok(userRole2);
	}

	@PostMapping("/roles")
	public ResponseEntity<Role> saveOrUpdate(@RequestBody Role role, Principal principal) {
		Role savedUser = roleRepository.save(role);

		return ResponseEntity.ok(savedUser);
	}
}
