package vn.fpt.diamond_shop.security.endpoint;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import vn.fpt.diamond_shop.controller.BaseController;
import vn.fpt.diamond_shop.security.AccountService;
import vn.fpt.diamond_shop.response.AuthResponse;
import vn.fpt.diamond_shop.request.LoginRequest;
import vn.fpt.diamond_shop.request.SignUpRequest;
import vn.fpt.diamond_shop.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.fpt.diamond_shop.security.UserPrincipal;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/shop/auth")
public class AuthController extends BaseController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String role = authorities.iterator().next().getAuthority();

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token, role));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        accountService.register(signUpRequest);

        return ok("User registered successfully", null);
    }

}
