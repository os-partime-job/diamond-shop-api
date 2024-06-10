package vn.fpt.diamond_shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.diamond_shop.constants.UrlConstants;
import vn.fpt.diamond_shop.request.GetListCartRequest;
import vn.fpt.diamond_shop.request.GetListDeliveryRequest;
import vn.fpt.diamond_shop.security.CurrentUser;
import vn.fpt.diamond_shop.security.UserPrincipal;
import vn.fpt.diamond_shop.service.DeliveryService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(UrlConstants.BASIC_DELIVERY_URL)
public class DeliveryController extends BaseController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("list")
    public ResponseEntity<Object> list(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody GetListDeliveryRequest request) {
        return deliveryService.listDelivery(request);
    }


    @PostMapping("add")
    public ResponseEntity<Object> add(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody GetListDeliveryRequest request) {
        return deliveryService.listDelivery(request);
    }
}
