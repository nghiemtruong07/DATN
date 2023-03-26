package com.example.pcthanhcongserver.forms;

import com.example.pcthanhcongserver.entity.ProductImage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductImageForm {
    private String imageUrl;

    public ProductImage toEntity(){
        return new ProductImage(imageUrl);
    }
}
