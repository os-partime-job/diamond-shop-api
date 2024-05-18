package vn.fpt.diamond_shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.fpt.diamond_shop.constants.UrlConstants;
import vn.fpt.diamond_shop.model.Diamond;
import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.model.JewelryType;
import vn.fpt.diamond_shop.request.CreateDiamondRequest;
import vn.fpt.diamond_shop.request.GetDetailJewelryRequest;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.response.GetDetailJewelryResponse;
import vn.fpt.diamond_shop.service.DiamondService;
import vn.fpt.diamond_shop.service.JewelryService;
import vn.fpt.diamond_shop.util.BaseResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(UrlConstants.BASIC_JEWELRY_URL)
public class JewelryController extends  BaseController{

    @Autowired
    private JewelryService jewelryService;

    @PostMapping("list")
    public ResponseEntity<Object> list(@Valid @RequestBody GetListJewelryRequest request) {
        return ok(jewelryService.jewelries(request), null);
    }
    @PostMapping("detail")
    public ResponseEntity<Object> detail(@Valid @RequestBody GetDetailJewelryRequest request) {
        return ok(jewelryService.detailJewelry(request.getIdJewelry()), null);
    }

    @GetMapping("jewelry_type")
    public ResponseEntity<Object> type() {
        return ok(jewelryService.jewelryType(), null);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateDiamondRequest request) {
        return ok(jewelryService.jewelryType(), null);
    }
}
