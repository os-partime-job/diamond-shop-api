package vn.fpt.diamond_shop.request;

import lombok.Data;

@Data
public class SendInvoiceRequest {
    private String orderId;
    private String date;
    private String mail;
    private Long customerId;
    private String total;
    private String address;
    private Products products;

    @Data
    public static class Products {
        private String name;
        private String price;
        private String quantity;
        private String image;
    }
}
