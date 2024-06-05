package vn.fpt.diamond_shop.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.fpt.diamond_shop.constants.StatusOrder;
import vn.fpt.diamond_shop.exception.DiamondShopException;
import vn.fpt.diamond_shop.model.Cart;
import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.model.OrderDetail;
import vn.fpt.diamond_shop.model.Orders;
import vn.fpt.diamond_shop.repository.*;
import vn.fpt.diamond_shop.request.*;
import vn.fpt.diamond_shop.response.*;
import vn.fpt.diamond_shop.service.OrderService;
import vn.fpt.diamond_shop.util.UUIDUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private JewelryRepository jewelryRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ImageRepository imageRepository;

    private static String ACTIVE_CART = "active";
    @Override
    public ResponseEntity<Object> orderList(GetListOrderRequest request) {
        List<GetListOrderResponse>orderResponses = new ArrayList<>();
        if(request.getLimit() == null){
            request.setLimit(10);
        }
        if(request.getOffset() == null){
            request.setOffset(0);
        }
        Page<GetListOrderResponse> orderList =  null;
        orderResponses = orderList.getContent();
        Meta meta = new Meta(request.getRequestId(), 200, "success", HttpStatus.OK.toString());
        meta.setLimit(request.getLimit());
        meta.setOffset(request.getOffset());
        meta.setTotal(Integer.valueOf(String.valueOf(orderList.getTotalElements()))) ;
        BaseResponse response = new BaseResponse(meta,orderResponses);

        return ResponseEntity.ok(response);
    }

    @Override
    public AddOrderResponse addOrder(AddOrderRequest request) {
        List<Cart> cartsById = cartRepository.findAllById(request.getCartIds());
        String uniqueOrderId = UUIDUtil.generateUUID();
        List<Long> listJewelris = new ArrayList<>();
        if(!cartsById.isEmpty()){
            Long priceItems = 0L;
            for(Cart cart : cartsById){
                //insert order detail
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDate(new Date(new java.util.Date().getTime()));
                orderDetail.setCreatedAt(new Date(new java.util.Date().getTime()));
                orderDetail.setJewelryId(cart.getJewelryId());
                orderDetail.setCustomerId(request.getCustomerId());
                orderDetail.setStatus(StatusOrder.INIT.getValue());
                orderDetail.setUniqueOrderId(uniqueOrderId);
                orderDetail.setQuantityNumber(cart.getQuantity());
                Optional<Jewelry> Jewelry = jewelryRepository.findById(cart.getJewelryId());
                Jewelry jewelryData = Jewelry.get();
                if(jewelryData != null){
                    orderDetail.setTotalPrice(cart.getQuantity()*jewelryData.getMaterialPrices());
                }
                priceItems += orderDetail.getTotalPrice();
                orderDetailRepository.save(orderDetail);
                listJewelris.add(cart.getJewelryId());
            }
            Orders orders = new Orders();
            orders.setUniqueOrderId(uniqueOrderId);
            orders.setOrderDate(new Date(new java.util.Date().getTime()));
            orders.setCreatedAt(new Date(new java.util.Date().getTime()));
            orders.setStatus(StatusOrder.CREATE_PAYMENT.getValue());
            orders.setTotalPrice(priceItems);
            ordersRepository.save(orders);


            AddOrderResponse response = new AddOrderResponse();
            response.setTotalPrice(priceItems);
            response.setUniqueOrderId(uniqueOrderId);
            response.setJewelryId(listJewelris);
            return response;
        }else{
           throw new DiamondShopException(400, "Dont exist cart info!");
        }
    }

    @Override
    public Object listCart(GetListCartRequest request) {
        List<ListCartResponse> listCartResponse = cartRepository.getListCartResponse(request.getCustomerId());
        return listCartResponse;
    }

    @Override
    public Boolean addCart(AddCartRequest request) {
        Cart byCustomerIdAndAndJewelryId = cartRepository.findByUserIdAndAndJewelryId(request.getCustomerId(), request.getJewelryId());
        if(byCustomerIdAndAndJewelryId != null){
            //update
            byCustomerIdAndAndJewelryId.setQuantity(byCustomerIdAndAndJewelryId.getQuantity() + request.getQuantity());
            byCustomerIdAndAndJewelryId.setUpdatedAt(new java.util.Date());
            cartRepository.updateByUserIdAndJewelryId(request.getCustomerId(), request.getJewelryId(), byCustomerIdAndAndJewelryId.getQuantity(), byCustomerIdAndAndJewelryId.getUpdatedAt(), byCustomerIdAndAndJewelryId.getStatus());
        }else{
            //insert
            Cart cart = new Cart();
            cart.setJewelryId(request.getJewelryId());
            cart.setQuantity(request.getQuantity());
            cart.setUserId(request.getCustomerId());
            cart.setCreatedAt(new Date(new java.util.Date().getTime()));
            cart.setStatus(ACTIVE_CART);
            cartRepository.save(cart);
        }

        return true;
    }

    @Override
    public Boolean updateCart(AddCartRequest request) {
        Cart byCustomerIdAndAndJewelryId = cartRepository.findByUserIdAndAndJewelryId(request.getCustomerId(), request.getJewelryId());
        if(byCustomerIdAndAndJewelryId != null){
            //update
            byCustomerIdAndAndJewelryId.setQuantity(byCustomerIdAndAndJewelryId.getQuantity() + request.getQuantity());
            byCustomerIdAndAndJewelryId.setUpdatedAt(new java.util.Date());
            if(!StringUtils.isEmpty(request.getStatus())){
                byCustomerIdAndAndJewelryId.setStatus(request.getStatus());
            }
            cartRepository.updateByUserIdAndJewelryId(request.getCustomerId(), request.getJewelryId(), byCustomerIdAndAndJewelryId.getQuantity(), byCustomerIdAndAndJewelryId.getUpdatedAt(), byCustomerIdAndAndJewelryId.getStatus());
        }
        return true;
    }

    @Override
    public Boolean deleteCart(DeleteCartRequest request) {
        cartRepository.deleteById(request.getCartId());
        return true;
    }
}
