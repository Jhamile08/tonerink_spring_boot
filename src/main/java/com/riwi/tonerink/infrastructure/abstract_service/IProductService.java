package com.riwi.tonerink.infrastructure.abstract_service;

import com.riwi.tonerink.api.dto.request.ProductRequest;
import com.riwi.tonerink.api.dto.response.ProductResponse;

public interface IProductService extends CrudService<ProductRequest, ProductResponse, Integer>{
    public String FIELD_BY_SORT = "Product";
}
