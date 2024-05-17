package vn.fpt.diamond_shop.service;

import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.response.GetDetailJewelryResponse;

import java.util.List;

public interface JewelryService {
    List<Jewelry> jewelries(GetListJewelryRequest request);

    GetDetailJewelryResponse detailJewelry(Integer id);
}
