package vn.fpt.diamond_shop.service;

import org.springframework.http.ResponseEntity;
import vn.fpt.diamond_shop.model.JewelryType;
import vn.fpt.diamond_shop.model.OrderDetail;
import vn.fpt.diamond_shop.request.AddOrderRequest;
import vn.fpt.diamond_shop.request.CreateDiamondRequest;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.request.GetListOrderRequest;
import vn.fpt.diamond_shop.response.AddOrderResponse;
import vn.fpt.diamond_shop.response.GetDetailJewelryResponse;

import java.util.List;

public interface OrderService {
    ResponseEntity<Object> orderList(GetListOrderRequest request);

    AddOrderResponse addOrder(AddOrderRequest request);
}
