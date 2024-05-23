package com.riwi.tonerink.api.dto.response;

import com.riwi.tonerink.util.enums.BrandEnum;
import com.riwi.tonerink.util.enums.QualityEnum;
import com.riwi.tonerink.util.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private TypeEnum typeProduct;
    private BrandEnum brandProduct;
    private QualityEnum qualityProduct;
    private String imgProduct;
    private String nameProduct;
    private String performanceProduct;
    private String compatibilityProduct;
    private String priceProduct;
}
