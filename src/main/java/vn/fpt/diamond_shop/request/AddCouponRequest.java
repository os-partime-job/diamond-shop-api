package vn.fpt.diamond_shop.request;

import lombok.Data;

@Data
public class AddCouponRequest {
    private String code;
    private String discountPercent;
    private String conditionType;
    private String type;
    private Long value;
    private Integer quantity;
}
