package vn.fpt.diamond_shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.fpt.diamond_shop.constants.UrlConstants;
import vn.fpt.diamond_shop.request.CreateDiamondRequest;
import vn.fpt.diamond_shop.request.GetDetailJewelryRequest;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.service.JewelryService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(UrlConstants.BASIC_ORDER_URL)
public class OrderController extends BaseController {

    @Autowired
    private OrderController jewelryService;

//    @PostMapping("list")
//    public ResponseEntity<Object> list(@Valid @RequestBody GetListJewelryRequest request) {
//        return ok(jewelryService.jewelries(request), null);
//    }

}
