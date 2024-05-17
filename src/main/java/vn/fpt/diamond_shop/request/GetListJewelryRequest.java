package vn.fpt.diamond_shop.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@Configuration
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetListJewelryRequest {
}
