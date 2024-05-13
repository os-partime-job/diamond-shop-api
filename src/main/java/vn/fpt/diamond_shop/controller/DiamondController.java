package vn.fpt.diamond_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.diamond_shop.constants.AppConstants;
import vn.fpt.diamond_shop.model.Diamond;
import vn.fpt.diamond_shop.util.BaseResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AppConstants.BASE_URL + "/diamonds")
public class DiamondController {

    @GetMapping("/list")
    public ResponseEntity<List<Diamond>> list(@RequestParam("page") int page,
                                              @RequestParam("size") int size) {
        List<Diamond> diamonds = new ArrayList<>();
        return BaseResponse.ok(diamonds);
    }

}
