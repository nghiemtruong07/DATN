package com.example.pcthanhcongserver.forms;

import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.validations.ProductTitleNotExists;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CreateProductForm {
    @NotBlank
    @Size(min = 3,message = "Tên sản phẩm phải dài hơn 3 ký tự")
    @ProductTitleNotExists(message = "Tên sản phẩm không được trùng nhau")
    private String title;

    @NotBlank
    private String specifications;
    @NotBlank
    private String descriptions;
    @Min(value = 0,message = "giá gốc phải lớn hơn 0")
    private int originalPrice;
    @Min(value = 0, message = "Giá khuyễn mại phải lớn hơn 0")
    private int promotionPrice;

    @Min(value = 0,message = "số lượng phải lớn hơn 0")
    private Integer amount;
    @NotNull
    private Integer categoryId;
    public Product toEntity(){
        Product product = new Product(
                title,
                specifications,
                descriptions,
                originalPrice,
                promotionPrice,
                amount);
        return product;
        }
}
