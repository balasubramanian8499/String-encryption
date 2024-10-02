package com.demo.stringencryption.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code")
    @ColumnTransformer(
            read = "CONVERT(AES_DECRYPT(UNHEX(product_code), '1234') USING utf8)",
            write = "HEX(AES_ENCRYPT(?, '1234'))")
    private Integer productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    @ColumnTransformer(
            read = "CONVERT(AES_DECRYPT(UNHEX(product_price),'1234') USING utf8)",
            write = "HEX(AES_ENCRYPT(?, '1234'))")
    private Integer productPrice;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

}
