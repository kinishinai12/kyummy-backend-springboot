package com.kinishinai.kyummybackend.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinishinai.kyummybackend.dto.AuthenticationResponse;
import com.kinishinai.kyummybackend.dto.RefreshTokenRequest;
import com.kinishinai.kyummybackend.dto.RegisterRequest;
import com.kinishinai.kyummybackend.exception.KyummyExistingResponse;
import com.kinishinai.kyummybackend.model.LoginRequest;
import com.kinishinai.kyummybackend.model.User;
import com.kinishinai.kyummybackend.service.AuthService;
import com.kinishinai.kyummybackend.service.RefreshTokenService;

@RestController
@RequestMapping("/kyummy/auth/")
//@CrossOrigin(origins="https://localhost:3000")
public class AuthController {
	@Autowired
	private AuthService authService;
	@Autowired
	private RefreshTokenService refreshTokenService;
	// api for signup
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody RegisterRequest registerRequest) {
		// if true execute this code
		if(authService.isUserEmailAlreadyExist(registerRequest)) {
			throw new KyummyExistingResponse("the email " +registerRequest.getEmail()+ " is already exist");
		}
		// if true execute this code
		if(authService.isPhoneNumberAlreadyExist(registerRequest)) {
			throw new KyummyExistingResponse("the phone number "+registerRequest.getPhoneNumber()+ "is already exist");
		}
		//if not true execute this code
		authService.signup(registerRequest);
		return new ResponseEntity<>("User Register Successfully", HttpStatus.OK);
	}
	
	//api for account verification
	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token){
		authService.verifyAccount(token);
		return new ResponseEntity<>("Account activated successfully", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
	
    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
    
    @GetMapping("/{userid}")
    public User getUserById(@PathVariable UUID userid){
    	return authService.getUserById(userid);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        
		refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }
    // post mapping for creating new password
}
