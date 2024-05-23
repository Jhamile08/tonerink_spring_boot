package com.riwi.tonerink.api.dto.request;

import com.riwi.tonerink.util.enums.BrandEnum;
import com.riwi.tonerink.util.enums.QualityEnum;
import com.riwi.tonerink.util.enums.TypeEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "El tipo del producto es requerido")
    private TypeEnum typeProduct;
    @NotBlank(message = "La marca del producto es requerido")
    private BrandEnum brandProduct;
    @NotBlank(message = "La calidad del producto requerido")
    private QualityEnum qualityProduct;
    @NotBlank(message = "La imagen del producto requerido")
    private String imgProduct;
    @NotBlank(message = "El nombre del producto requerido")
    private String nameProduct;
    @NotBlank(message = "El rendimiento del producto es requerido")
    private String performanceProduct;
    @NotBlank(message = "La compatibilidad del producto es requerido")
    private String compatibilityProduct;
}
