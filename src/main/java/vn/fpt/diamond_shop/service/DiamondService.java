package vn.fpt.diamond_shop.service;


import vn.fpt.diamond_shop.model.Diamond;
import vn.fpt.diamond_shop.payload.AddDiamondRequest;
import vn.fpt.diamond_shop.payload.ListDiamondReponse;

import java.util.List;

public interface DiamondService {
    void addDiamond(AddDiamondRequest addDiamondRequest);

    List<ListDiamondReponse> listDiamonds();

}
