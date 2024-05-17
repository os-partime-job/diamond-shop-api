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
import vn.fpt.diamond_shop.request.CreateDiamondRequest;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.service.DiamondService;
import vn.fpt.diamond_shop.service.JewelryService;
import vn.fpt.diamond_shop.util.BaseResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(UrlConstants.BASIC_JEWELRY_URL)
public class JewelryController {

    @Autowired
    private JewelryService jewelryService;

    @PostMapping("list")
    public ResponseEntity<List<Jewelry>> list(@Valid @RequestBody GetListJewelryRequest request) {
        return new ResponseEntity<>(jewelryService.jewelries(request), HttpStatus.OK);
    }
    @PostMapping("detail")
    public ResponseEntity<List<Jewelry>> detail(@Valid @RequestBody GetListJewelryRequest request) {
        return new ResponseEntity<>(jewelryService.jewelries(request), HttpStatus.OK);
    }
}
