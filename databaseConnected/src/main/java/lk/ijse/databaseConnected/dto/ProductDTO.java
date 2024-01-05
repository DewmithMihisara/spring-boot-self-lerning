package lk.ijse.databaseConnected.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private Integer qtty;
    private Double price;
    private Long categoryId;
}
