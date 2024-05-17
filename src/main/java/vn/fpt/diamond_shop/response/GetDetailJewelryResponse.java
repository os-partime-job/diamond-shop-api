package vn.fpt.diamond_shop.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import java.sql.Date;
import java.util.UUID;

@Data
@Configuration
@AllArgsConstructor

public class GetDetailJewelryResponse {

    private String jewelryCode;

    private String jewelryType;

    private Integer quantity;

    private Double materialPrices;

    private Integer idGuide;

    private Integer isActive;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private String name;
}
