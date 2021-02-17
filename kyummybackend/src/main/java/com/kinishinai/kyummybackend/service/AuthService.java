package com.kinishinai.kyummybackend.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinishinai.kyummybackend.dto.AuthenticationResponse;
import com.kinishinai.kyummybackend.dto.RefreshTokenRequest;
import com.kinishinai.kyummybackend.dto.RegisterRequest;
import com.kinishinai.kyummybackend.exception.KyummyMailException;
import com.kinishinai.kyummybackend.model.LoginRequest;
import com.kinishinai.kyummybackend.model.NotificationEmail;
import com.kinishinai.kyummybackend.model.User;
import com.kinishinai.kyummybackend.model.VerificationToken;
import com.kinishinai.kyummybackend.repository.UserRepository;
import com.kinishinai.kyummybackend.repository.VerificationTokenRepository;
import com.kinishinai.kyummybackend.security.JWTProvider;

@Service
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	@Autowired
	private MailService mailService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTProvider jwtProvider;
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	// register the user
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setPhoneNumber(registerRequest.getPhoneNumber());
		user.setVerified(false);
		user.setDateCreated(Instant.now());
		user.setGender(registerRequest.getGender());
		user.setBirthday(registerRequest.getBirthday());
		
		userRepository.save(user);
		
		String token = generateVerificationToken(user);  
		mailService.sendMail(new NotificationEmail("Please activate your account",
				user.getEmail(),
				"thank you for signing up to Kyummy, "+"please click on the below url to activate your account: "+
				"http://localhost:8080/kyummy/auth/accountVerification/" + token));
	}
	
	public User getUserById(UUID userid) {
		return userRepository.findById(userid).get();
	}
	
	public UUID getUserIdByEmail(String email) {
		return userRepository.findByEmail(email).get().getId();
	}
	
	// generate verification token
	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);
		
		verificationTokenRepository.save(verificationToken);
		return token;
	}
	
	// Verify the account
	public void verifyAccount(String token) {
		Optional<VerificationToken>verificationToken = verificationTokenRepository.findByToken(token);
		verificationToken.orElseThrow(() -> new KyummyMailException("invalid token"));
		fetchUserAndEnable(verificationToken.get());
	}
	
	// check if Email is already exist in the database
	public boolean isUserEmailAlreadyExist(RegisterRequest registerRequest ) {
		String email = registerRequest.getEmail();
		return userRepository.existsByEmail(email);
	}
	
	// check if phone number is already exist in the database
	public boolean isPhoneNumberAlreadyExist(RegisterRequest registerRequest) {
		String phoneNumber = registerRequest.getPhoneNumber();
		return userRepository.existsByPhoneNumber(phoneNumber);
	}
	
	// fetching and enabling the account 
	@Transactional
	private void fetchUserAndEnable(VerificationToken verificationToken) {
		String email = verificationToken.getUser().getEmail();
		User user = userRepository.findByEmail(email).orElseThrow(()-> new KyummyMailException("user not found"));
		user.setVerified(true);
		userRepository.save(user);
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {
		 Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), 
				loginRequest.getPassword()));
		 SecurityContextHolder.getContext().setAuthentication(authenticate);
	        String token = jwtProvider.generateToken(authenticate);
	        return AuthenticationResponse.builder()
	                .authenticationToken(token)
	                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
	                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
	                .username(loginRequest.getEmail())
	                .id(getUserIdByEmail(loginRequest.getEmail()))
	                .build();
		
	}
	
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .id(getUserIdByEmail(refreshTokenRequest.getUsername()))
                .build();
    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
	
	
}
