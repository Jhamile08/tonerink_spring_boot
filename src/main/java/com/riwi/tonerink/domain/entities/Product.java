package com.riwi.tonerink.domain.entities;

import com.riwi.tonerink.util.enums.BrandEnum;
import com.riwi.tonerink.util.enums.QualityEnum;
import com.riwi.tonerink.util.enums.TypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private TypeEnum typeProduct;
    @Column(nullable = false)
    private BrandEnum brandProduct;
    @Column(nullable = false)
    private QualityEnum qualityProduct;
    @Column(nullable = false)
    private String imgProduct;
    @Column(nullable = false)
    private String nameProduct;
    @Column(nullable = false)
    private String performanceProduct;
    @Column(nullable = false)
    private String compatibilityProduct;

}
