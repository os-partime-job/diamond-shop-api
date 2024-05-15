package vn.fpt.diamond_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpt.diamond_shop.model.Diamond;
import vn.fpt.diamond_shop.payload.AddDiamondRequest;
import vn.fpt.diamond_shop.payload.ListDiamondReponse;
import vn.fpt.diamond_shop.repository.DiamondRepository;

import java.util.List;

@Service
public class DiamondServiceImpl implements DiamondService {
    @Autowired
    private DiamondRepository diamondRepo;


    public long diamondPricing(Diamond diamond) {
        return 0;
    }

    @Override
    public void addDiamond(AddDiamondRequest addDiamondRequest) {

    }

    @Override
    public List<ListDiamondReponse> listDiamonds() {
        List<Diamond> diamonds = diamondRepo.findAll();
    }
}
