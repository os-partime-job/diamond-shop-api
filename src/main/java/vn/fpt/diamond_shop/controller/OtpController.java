package vn.fpt.diamond_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/otp")
public class OtpController extends BaseController {

    @GetMapping("")
    public ResponseEntity<?> checkOtp(@RequestParam(required = true, name = "otp") int otp,
                                      @RequestParam(required = true, name = "email") String email) {
        return ok("OTP ok", null);
    }
}
