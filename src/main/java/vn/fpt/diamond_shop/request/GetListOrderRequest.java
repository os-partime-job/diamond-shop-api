package vn.fpt.diamond_shop.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetListOrderRequest extends BaseRequest{
    private Long customerId;
    private String phoneNumber;
    private String orderId;
    private String status;
    private Integer limit;
    private Integer offset;
    private String sort;
    private Boolean isDelivery;
    private Long deliveryId;
}
