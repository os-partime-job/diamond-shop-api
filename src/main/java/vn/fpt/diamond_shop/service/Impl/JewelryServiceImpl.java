package vn.fpt.diamond_shop.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpt.diamond_shop.model.Diamond;
import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.model.JewelryType;
import vn.fpt.diamond_shop.payload.AddDiamondRequest;
import vn.fpt.diamond_shop.payload.ListDiamondReponse;
import vn.fpt.diamond_shop.repository.DiamondRepository;
import vn.fpt.diamond_shop.repository.JewelryRepository;
import vn.fpt.diamond_shop.repository.JewelryTypeRepository;
import vn.fpt.diamond_shop.request.CreateDiamondRequest;
import vn.fpt.diamond_shop.request.GetListJewelryRequest;
import vn.fpt.diamond_shop.response.GetDetailDiamondResponse;
import vn.fpt.diamond_shop.response.GetDetailJewelryResponse;
import vn.fpt.diamond_shop.service.DiamondService;
import vn.fpt.diamond_shop.service.JewelryService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class JewelryServiceImpl implements JewelryService {
    @Autowired
    private JewelryRepository jewelryRepository;

    @Autowired
    private JewelryTypeRepository jewelryTypeRepository;

    private static String JEWELRY_CODE_DEFAULT = "DMS_";

    @Override
    public List<Jewelry> jewelries(GetListJewelryRequest request) {
        return jewelryRepository.findAll();
    }

    @Override
    public GetDetailJewelryResponse detailJewelry(Long id) {
        return null;
//        return jewelryRepository.getDetailJewelry(id);
    }

    @Override
    public List<JewelryType> jewelryType() {
        return jewelryTypeRepository.findAll();
    }

    @Override
    public boolean createJewelry(CreateDiamondRequest request) {

        Jewelry jewelry = new Jewelry();
        BeanUtils.copyProperties(request, jewelry);
        jewelry.setJewelryCode(jewelryCode());
//        jewelry.setCreatedAt(new Date(New ));

        return false;
    }

    private String jewelryCode() {
        long count = jewelryTypeRepository.count();
        return JEWELRY_CODE_DEFAULT + count;
    }
}
