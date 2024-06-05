package vn.fpt.diamond_shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.diamond_shop.constants.UrlConstants;
import vn.fpt.diamond_shop.request.AddCartRequest;
import vn.fpt.diamond_shop.request.AddOrderRequest;
import vn.fpt.diamond_shop.request.GetListCartRequest;
import vn.fpt.diamond_shop.request.GetListOrderRequest;
import vn.fpt.diamond_shop.security.CurrentUser;
import vn.fpt.diamond_shop.security.UserPrincipal;
import vn.fpt.diamond_shop.service.OrderService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(UrlConstants.BASIC_CART_URL)
public class CartController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping("list")
    public ResponseEntity<Object> list(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody GetListCartRequest request) {
        request.setCustomerId(userPrincipal.getId());
        return ok(orderService.listCart(request));
    }
    @PostMapping("add_card")
    public ResponseEntity<Object> addCart(@CurrentUser UserPrincipal userPrincipal,@Valid @RequestBody AddCartRequest request) {
        request.setCustomerId(userPrincipal.getId());
        return ok(orderService.addCart(request));
    }

    @PostMapping("update")
    public ResponseEntity<Object> updateCart(@CurrentUser UserPrincipal userPrincipal,@Valid @RequestBody AddCartRequest request) {
        request.setCustomerId(userPrincipal.getId());
        return ok(orderService.updateCart(request));
    }
}
