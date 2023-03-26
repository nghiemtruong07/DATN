package com.example.pcthanhcongserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotBlank
    @Size(min = 20)
    private String title;

    @NotBlank
    @Size(max = 1000)
    private String specifications;

    @NotBlank
    @Size(max = 2000)
    private String descriptions;

    private Integer originalPrice;
    private Integer promotionPrice;
    private Integer categoryId;
    private Integer amount;
    private List<ProductImagesDTO> productImages;

    @Data
    @NoArgsConstructor
    static class ProductImagesDTO{
        @NotBlank
        private String imageUrl;
    }

}
