package vn.fpt.diamond_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.diamond_shop.request.AddCouponRequest;
import vn.fpt.diamond_shop.request.ModifyCouponRequest;
import vn.fpt.diamond_shop.request.UsingCouponRequest;
import vn.fpt.diamond_shop.service.CouponService;

@RestController
@RequestMapping("/shop/coupon")
public class CouponController extends BaseController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCoupons() {
        return ok(couponService.getAllCoupons());
    }

    @GetMapping("")
    public ResponseEntity<?> getCoupon(@RequestParam(name = "id", required = false) Long id,
                                       @RequestParam(name = "code", required = false) String code) {
        return ok(couponService.getCoupon(id, code));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCoupon(@RequestBody AddCouponRequest addCouponRequest) {
        return ok(couponService.addCoupon(addCouponRequest));
    }

    @PutMapping("/use")
    public ResponseEntity<?> useCoupon(@RequestBody UsingCouponRequest usingCouponRequest) {
        couponService.usingCoupon(usingCouponRequest);
        return ok("Used coupon successfully");
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyCoupon(@RequestBody ModifyCouponRequest addCouponRequest) {
        couponService.modifyCoupon(addCouponRequest);
        return ok("Modified coupon successfully");
    }

    @DeleteMapping("/deactivate")
    public ResponseEntity<?> deactivateCoupon(@RequestParam(name = "code", required = true) String couponCode) {
        couponService.deactivateCoupon(couponCode);
        return ok("Deactivated coupon successfully");
    }

}
