package com.example.pcthanhcongserver.forms;

import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.validations.ProductTitleNotExists;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UpdateProductForm {
    @NotBlank
    @Size(min = 3, message = "Tên sản phảm phải dài hơn 3 kí tự")
    @ProductTitleNotExists(message = "Tên sản phẩm không được trùng")
    private String title;

    @NotBlank
    private String specifications;
    @NotBlank
    private String descriptions;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private int originalPrice;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private int promotionPrice;

    @Min(value = 0 , message = "Giá gốc phải hơn  0")
    private Integer amount;


    public Product toEntity(){
        Product p = new Product(
                title,
                specifications,
                descriptions,
                originalPrice,
                promotionPrice,
                amount);
        return p;
    }
}
