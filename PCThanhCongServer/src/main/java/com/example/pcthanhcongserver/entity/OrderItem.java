package com.example.pcthanhcongserver.entity;

import com.example.pcthanhcongserver.contants.StatusOrderItem;
import com.example.pcthanhcongserver.contants.StatusOrderItemConvert;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "received_Date",columnDefinition = "null")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "`status`", columnDefinition = "Processing")
    @Convert(converter = StatusOrderItemConvert.class)
    private StatusOrderItem status;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    @JsonIgnore
    private  Order order;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    @JsonIgnore
    private Product product;

    @PrePersist
    public void prePersist(){
        if(this.status == null)
            this.status = StatusOrderItem.Processing;
    }

    public OrderItem(Integer amount, Order order, Product product){
        this.amount = amount;
        this.order = order;
        this. product = product;
    }


}
