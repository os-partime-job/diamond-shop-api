package vn.fpt.diamond_shop.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateDiamondRequest extends BaseRequest{

    @Column(name = "id_diamond")
    private Long idDiamond;

    @Column(name = "jewelry_type_id")
    private Long jewelryTypeId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "material_prices")
    private Double materialPrices;

    @Column(name = "id_guide")
    private Integer idGuide;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "image_id")
    private Long imageId;

}
