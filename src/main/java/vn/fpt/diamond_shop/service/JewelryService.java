package vn.fpt.diamond_shop.service;

import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;

import java.util.List;

public interface JewelryService {
    List<Jewelry> jewelries(GetListJewelryRequest request);
}
