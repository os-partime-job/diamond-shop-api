package vn.fpt.diamond_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.diamond_shop.request.AddCouponRequest;

@RestController
@RequestMapping("/shop/coupon")
public class CouponController extends BaseController {

    public ResponseEntity<?> addCoupon(AddCouponRequest addCouponRequest) {
        return null;
    }

    public ResponseEntity<?> deactivateCoupon(String couponCode) {
        return null;
    }

    public ResponseEntity<?> checkCoupon(String couponCode, Long userId) {
    }

}
