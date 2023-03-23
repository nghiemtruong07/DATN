package com.example.pcthanhcongserver.contants;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StatusOrderItemConvert implements AttributeConverter<StatusOrderItem, String> {
    @Override
    public String convertToDatabaseColumn(StatusOrderItem attribute){
        if (attribute == null)
                return null;
        return attribute.getValue();
    }

    @Override
    public StatusOrderItem convertToEntityAttribute(String status) {
        return StatusOrderItem.of(status);
    }
}
