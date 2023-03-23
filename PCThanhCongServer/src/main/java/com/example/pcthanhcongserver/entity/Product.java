package com.example.pcthanhcongserver.entity;

import com.example.pcthanhcongserver.contants.StatusCodeProductEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table
public class Product implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`title`",length = 255,nullable = false)
    private String title;

    @Column(name = "`specifications`", length = 1000, nullable = false)
    private String specifications;

    @Column(name = "`descriptions`", length = 2000, nullable = false)
    private String descriptions;

    @Column(name = "originalPrice", nullable = false)
    private Integer originalPrice;

    @Column(name = "promotionPrice", nullable = false)
    private Integer promotionPrice;

    @Column(name = "`created_Date`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "`status`", columnDefinition = "1")
    private StatusCodeProductEnum status;

    public Product(String title, String specifications, String descriptions, int originalPrice, int promotionPrice, Integer amount)
    {
        this.title = title;
        this.specifications = specifications;
        this.descriptions = descriptions;
        this.originalPrice = originalPrice;
        this.promotionPrice = promotionPrice;
        this.amount = amount;
    }



}
