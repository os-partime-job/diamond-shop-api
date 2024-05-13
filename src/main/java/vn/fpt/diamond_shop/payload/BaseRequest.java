package vn.fpt.diamond_shop.payload;

import lombok.Data;

@Data
public class BaseRequest {
    private int page;
    private int size;
}
